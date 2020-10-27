package com.dragueo.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dragueo.web.model.Piloto;

public interface PilotoRepository extends CrudRepository<Piloto, Long>{
	List<Piloto> findAll();
	
	List<Piloto> findAllByOrderByIdDesc();
}
