package com.dragueo.web.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragueo.web.model.Date;
import com.dragueo.web.model.Time;
import com.dragueo.web.model.TimeNative;
import com.dragueo.web.model.Top;
import com.dragueo.web.repository.TimeRepository;

@Service
public class TimeServiceImpl implements TimeService {
	@Autowired
	private TimeRepository timeRepository;

	@Override
	public Iterable<Time> findAll() {
		return timeRepository.findAll();
	}

	@Override
	public List<Top> findTop() {
		return timeRepository.findTop()
				.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Top::getEntry))))
				.stream()
				.sorted(Comparator.comparing(Top::getFt1320))
				.limit(100)
				.collect(Collectors.toList());
	}

	@Override
	public List<Date> findDate() {
		return timeRepository.findDate();
	}

	@Override
	public List<TimeNative> findTimeByDate(String fecha) {
		return timeRepository.findTimeByDate(fecha);
	}

	@Override
	public TimeNative findTimeById(long id) {
		return timeRepository.findTimeById(id);
	}

	@Override
	public List<TimeNative> findTimeRightNow() {
		return timeRepository.findTimeRightNow();
	}

	@Override
	public Time save(Time time) {
		time = timeRepository.save(time);
		timeRepository.refresh(time);
		return time;
	}

	@Override
	public Optional<Time> findById(long id) {
		return timeRepository.findById(id);
	}

}
