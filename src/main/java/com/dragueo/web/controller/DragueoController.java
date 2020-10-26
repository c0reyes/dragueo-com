package com.dragueo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dragueo.web.service.TimeServiceImpl;

@Controller
public class DragueoController {
	@Autowired
	private TimeServiceImpl timeService;
	
	@GetMapping("/semaforo")
	public String getSemaforo(Model model) {
		model.addAttribute("times", timeService.findTimeRightNow());
		return "semaforo";
	}
	
	@GetMapping("/historico")
	public String getHistorico(Model model) {
		model.addAttribute("dates", timeService.findDate());
		return "historico";
	}
	
	@GetMapping("/historico/{dd}/{mm}/{yy}")
	public String getHistorico(@PathVariable String dd, @PathVariable String mm,
			@PathVariable String yy, Model model) {
		model.addAttribute("times", timeService.findTimeByDate(String.format("%s/%s/%s", dd, mm, yy)));
		model.addAttribute("dates", timeService.findDate());
		return "historico";
	}
	
	@GetMapping("/top")
	public String getTop(Model model) {
		model.addAttribute("top", timeService.findTop());
		return "top";
	}
}
