package com.dragueo.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dragueo.web.model.Date;
import com.dragueo.web.model.Time;
import com.dragueo.web.model.TimeNative;
import com.dragueo.web.model.Top;

@Repository
public interface TimeRepository extends CustomRepository<Time, Long> {
	@Query(value = "select distinct time, entry, treespeed, dialin, reaction, ft60, ft330, ft660, mph1, ft1320, mph, first1, statusLeft, fecha, piloto, car, flag from (" +
			"(SELECT " +
			"	time, entryLeft entry, treespeedLeft treespeed, dialinLeft dialin, reactionLeft reaction, ft60Left ft60, ft330Left ft330, " +
			"	ft660Left ft660, mph1Left mph1, ft1320Left ft1320, mphLeft mph, firstLeft first1, " +
			"	statusLeft, date_format(ifnull(str_to_date(fecha,'%m %d, %Y %h:%i:%s %p'),ent_date),'%d/%m/%y') fecha," +
			"	t2.piloto piloto, t2.carro car, t2.pais flag " +
			"FROM times as t0 left JOIN pilotos AS t2 ON t0.entryLeft = t2.numero " +
			"WHERE CONVERT(t0.ft60Left,DECIMAL(10,3)) > 0 " +
			"and CONVERT(t0.ft660Left,DECIMAL(10,3)) > 0 " +
			"and CONVERT(t0.ft1320Left,DECIMAL(10,3)) > 0 " +
			"and entryLeft REGEXP '^[0-9]+\\.?[0-9]*$'" +
			"order by CONVERT(t0.ft1320Left,DECIMAL(10,3)) asc limit 400) " +
			"union " +
			"(SELECT " + 
			"	time, entryRight entry, treespeedRight treespeed, dialinRight dialin, reactionRight reaction, ft60Right ft60, ft330Right ft330, " +
			"	ft660Right ft660, mph1Right mph1, ft1320Right ft1320, mphRight mph, firstRight first1,  " +
			"	statusRight, date_format(ifnull(str_to_date(fecha,'%m %d, %Y %h:%i:%s %p'),ent_date),'%d/%m/%y') fecha,  " +
			"	t3.piloto piloto, t3.carro car, t3.pais flag " +
			"FROM times as t1 left JOIN pilotos AS t3 ON t1.entryRight = t3.numero " +
			"WHERE CONVERT(t1.ft60Right,DECIMAL(10,3)) > 0 " +
			"and CONVERT(t1.ft660Right,DECIMAL(10,3)) > 0 " +
			"and CONVERT(t1.ft1320Right,DECIMAL(10,3)) > 0 " +
			"and entryRight REGEXP '^[0-9]+\\.?[0-9]*$'" +
			"order by CONVERT(t1.ft1320Right,DECIMAL(10,3)) asc limit 400) " +
			") tiempos order by convert(ft1320,DECIMAL(10,3)) asc", nativeQuery = true)
	public List<Top> findTop();
	
	@Query(value = "SELECT  " +
		    "distinct date_format(ifnull(str_to_date(t1.fecha,'%m %d, %Y %h:%i:%s %p'),ent_date),'%d/%m/%y') fecha,  " +
		    "date_format(ifnull(str_to_date(t1.fecha,'%m %d, %Y %h:%i:%s %p'),ent_date),'%Y%m%d') d,  " +
		    "t1.id_track track, " +
		    "ifnull(evento,'')  evento " +
		    "FROM times as t1  " +
		    "left join eventos as t2 on date_format(ifnull(str_to_date(t1.fecha,'%m %d, %Y %h:%i:%s %p'),t1.ent_date),'%d/%m/%y') = t2.fecha  " +
		    "group by fecha order by d desc", nativeQuery = true)
	public List<Date> findDate();
	
	@Query(value = "SELECT time time, entryLeft, entryRight, treespeedLeft, treespeedRight, dialinLeft, dialinRight, reactionLeft, " + 
        "reactionRight, ft60Left, ft60Right, ft330Left, ft330Right, ft660Left, ft660Right, mph1Left, mph1Right, ft1320Left, ft1320Right, " + 
        "mphLeft, mphRight, firstLeft, firstRight, statusLeft, statusRight, date_format(ifnull(str_to_date(fecha,'%m %d, %Y %h:%i:%s %p'),ent_date), " +
        "'%d/%m/%y %h:%i %p') fecha, t2.piloto driverLeft, t3.piloto driverRight, t2.carro carLeft, t3.carro carRight FROM times as t1 " + 
        "left JOIN pilotos AS t2 ON t1.entryLeft = t2.numero left JOIN pilotos AS t3 ON t1.entryRight = t3.numero where " + 
        "date_format(ifnull(str_to_date(fecha,'%m %d, %Y %h:%i:%s %p'),ent_date),'%d/%m/%y') = :fecha order by time desc", nativeQuery = true)
	public List<TimeNative> findTimeByDate(@Param("fecha") String fecha);
	
	@Query(value = "SELECT time id, time time, entryLeft, entryRight, treespeedLeft, treespeedRight, dialinLeft, dialinRight, " +
		    "reactionLeft, reactionRight, ft60Left, ft60Right, ft330Left, ft330Right, ft660Left, ft660Right, mph1Left, mph1Right, ft1320Left, " + 
		    "ft1320Right, mphLeft, mphRight, firstLeft, firstRight, statusLeft, statusRight, date_format(ifnull(str_to_date(fecha,'%m %d, %Y %h:%i:%s %p'),ent_date), " +
		    "'%d/%m/%y %h:%i %p') fecha, t2.piloto driverLeft, t3.piloto driverRight, t2.carro carLeft, t3.carro carRight FROM times as t1 " +
		    "left JOIN pilotos AS t2 ON t1.entryLeft = t2.numero left JOIN pilotos AS t3 ON t1.entryRight = t3.numero where t1.ent_date >  " +
		    "date_sub(current_timestamp, interval 3 day) order by id desc", nativeQuery = true)
	public List<TimeNative> findTimeRightNow();
	
	@Query(value = "SELECT time id, time time, entryLeft, entryRight, treespeedLeft, treespeedRight, dialinLeft, dialinRight, reactionLeft, " + 
		    "reactionRight, ft60Left, ft60Right, ft330Left, ft330Right, ft660Left, ft660Right, mph1Left, mph1Right, ft1320Left, ft1320Right, mphLeft, " +
		    "mphRight, firstLeft, firstRight, statusLeft, statusRight, date_format(ifnull(str_to_date(fecha,'%m %d, %Y %h:%i:%s %p'),ent_date),'%d/%m/%y %h:%i %p') fecha, " + 
		    "t2.piloto driverLeft, t3.piloto driverRight, t2.carro carLeft, t3.carro carRight, t2.pais countryLeft, t3.pais countryRight FROM times as t1 " +
		    "left JOIN pilotos AS t2 ON t1.entryLeft = t2.numero left JOIN pilotos AS t3 ON t1.entryRight = t3.numero where t1.time = :id", nativeQuery = true)
	public TimeNative findTimeById(@Param("id") long id);
}
