package com.dragueo.web.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragueo.web.model.Evento;
import com.dragueo.web.model.Piloto;
import com.dragueo.web.service.EventoServiceImpl;
import com.dragueo.web.service.PilotoServiceImpl;
import com.dragueo.web.service.TimeServiceImpl;

@Controller
public class DragueoController {
	@Autowired
	private TimeServiceImpl timeService;
	
	@Autowired
	private EventoServiceImpl eventoService;
	
	@Autowired
	private PilotoServiceImpl pilotoService;
	
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

	@GetMapping({"/admin/","/admin/evento"})
	public String getEventos(Model model) {
		model.addAttribute("eventos", eventoService.findAll());
		return "admin/evento";
	}
	
	@GetMapping("/admin/evento/d/{id}")
	public String delEvento(@PathVariable long id, Model model) {
		try {
			eventoService.deleteById(id);
			model.addAttribute("msg", new HashMap<String, String>(){{
						put("classname","alert-success"); 
						put("text","Evento eliminado");
			}});
		}catch(Exception ex) {
			model.addAttribute("msg", new HashMap<String, String>(){{
				put("classname","alert-danger"); 
				put("text","Error eliminado evento, exception: " + ex.toString());
			}});
		}
		model.addAttribute("eventos", eventoService.findAll());
		return "admin/evento";
	}
	
	@PostMapping("/admin/evento")
	public String postEvento(@RequestParam(name="fecha") String fecha, 
			@RequestParam(name="evento") String evento, Model model) {
		try {
			eventoService.save(new Evento(fecha, evento));
			model.addAttribute("msg", new HashMap<String, String>(){{
				put("classname","alert-success"); 
				put("text","Evento agregado");
			}});
		}catch(Exception ex) {
			model.addAttribute("msg", new HashMap<String, String>(){{
				put("classname","alert-danger"); 
				put("text","Error agregando evento, exception: " + ex.toString());
			}});
		}
		model.addAttribute("eventos", eventoService.findAll());
		return "admin/evento";
	}
	
	@GetMapping("/admin/piloto")
	public String getPilotos(Model model) {
		model.addAttribute("pilotos", pilotoService.findAll());
		return "admin/piloto";
	}
	
	@GetMapping("/admin/piloto/d/{id}")
	public String delPiloto(@PathVariable long id, Model model) {
		try {
			pilotoService.deleteById(id);
			model.addAttribute("msg", new HashMap<String, String>(){{
						put("classname","alert-success"); 
						put("text","Piloto eliminado");
			}});
		}catch(Exception ex) {
			model.addAttribute("msg", new HashMap<String, String>(){{
				put("classname","alert-danger"); 
				put("text","Error eliminado piloto, exception: " + ex.toString());
			}});
		}
		model.addAttribute("pilotos", pilotoService.findAll());
		return "admin/piloto";
	}
	
	@PostMapping("/admin/piloto")
	public String postPiloto(@RequestParam(name="numero") String numero, 
			@RequestParam(name="piloto") String piloto,
			@RequestParam(name="carro") String carro,
			@RequestParam(name="pais") String pais, Model model) {
		try {
			pilotoService.save(new Piloto(numero, piloto, carro, pais));
			model.addAttribute("msg", new HashMap<String, String>(){{
				put("classname","alert-success"); 
				put("text","Piloto agregado");
			}});
		}catch(Exception ex) {
			model.addAttribute("msg", new HashMap<String, String>(){{
				put("classname","alert-danger"); 
				put("text","Error agregando piloto, exception: " + ex.toString());
			}});
		}
		model.addAttribute("pilotos", pilotoService.findAll());
		return "admin/piloto";
	}
}
