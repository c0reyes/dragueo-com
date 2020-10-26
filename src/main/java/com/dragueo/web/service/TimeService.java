package com.dragueo.web.service;

import java.util.List;
import java.util.Optional;

import com.dragueo.web.model.Date;
import com.dragueo.web.model.Time;
import com.dragueo.web.model.TimeNative;
import com.dragueo.web.model.Top;

public interface TimeService {
	Iterable<Time> findAll();
	
	List<Top> findTop();
	
	List<Date> findDate();

	List<TimeNative> findTimeByDate(String fecha);
	
	List<TimeNative> findTimeRightNow();
	
	TimeNative findTimeById(long id);
	
	Time save(Time time);
	
	Optional<Time> findById(long id);
}