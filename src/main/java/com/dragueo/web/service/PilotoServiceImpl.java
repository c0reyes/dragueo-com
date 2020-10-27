package com.dragueo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragueo.web.model.Piloto;
import com.dragueo.web.repository.PilotoRepository;

@Service
public class PilotoServiceImpl implements PilotoService {
	
	@Autowired
	private PilotoRepository pilotoRepository;

	@Override
	public Piloto save(Piloto piloto) {
		return pilotoRepository.save(piloto);
	}

	@Override
	public void deleteById(long id) {
		pilotoRepository.deleteById(id);
	}

	@Override
	public List<Piloto> findAll() {
		return pilotoRepository.findAllByOrderByIdDesc();
	}

}
