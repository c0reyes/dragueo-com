package com.dragueo.web.service;

import java.util.List;

import com.dragueo.web.model.Evento;

public interface EventoService {
	Evento save(Evento evento);
	
	void deleteById(long id);
	
	List<Evento> findAll();
}
