package com.dragueo.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dragueo.web.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {
	List<Evento> findAll();
	
	List<Evento> findAllByOrderByFechaDesc();
	
	List<Evento> findAllByOrderByIdDesc();
}
