package com.dragueo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragueo.web.model.Evento;
import com.dragueo.web.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public Evento save(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public void deleteById(long id) {
		eventoRepository.deleteById(id);
	}

	@Override
	public List<Evento> findAll() {
		return eventoRepository.findAllByOrderByIdDesc();
	}

}
