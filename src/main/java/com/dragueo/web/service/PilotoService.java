package com.dragueo.web.service;

import java.util.List;

import com.dragueo.web.model.Piloto;

public interface PilotoService {
	Piloto save(Piloto piloto);
	
	void deleteById(long id);
	
	List<Piloto> findAll();
}
