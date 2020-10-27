package com.dragueo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragueo.web.model.Time;
import com.dragueo.web.model.TimeNative;
import com.dragueo.web.service.TimeServiceImpl;

@RestController
@RequestMapping("/api/v1/dragtree")
public class DragueoRestController {
	@Autowired
	private TimeServiceImpl timeService;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@GetMapping("/time/{id}")
	public TimeNative getTime(@PathVariable("id") long id) {
		return timeService.findTimeById(id);
	}
	
	@GetMapping("/add")
	public void greetx(@RequestParam(name = "entryLeft", required = false, defaultValue = "") String entryLeft, 
			  	@RequestParam(name = "entryRight", required = false, defaultValue = "") String entryRight, 
			  	@RequestParam(name = "treespeedLeft", required = false, defaultValue = "") String treespeedLeft, 
			  	@RequestParam(name = "treespeedRight", required = false, defaultValue = "") String treespeedRight, 
			  	@RequestParam(name = "dialinLeft", required = false, defaultValue = "") String dialinLeft,
				@RequestParam(name = "dialinRight", required = false, defaultValue = "") String dialinRight, 
				@RequestParam(name = "reactionLeft", required = false, defaultValue = "") String reactionLeft, 
				@RequestParam(name = "reactionRight", required = false, defaultValue = "") String reactionRight, 
				@RequestParam(name = "ft60Left", required = false, defaultValue = "") String ft60Left, 
				@RequestParam(name = "ft60Right", required = false, defaultValue = "") String ft60Right,
				@RequestParam(name = "ft330Left", required = false, defaultValue = "") String ft330Left, 
				@RequestParam(name = "ft330Right", required = false, defaultValue = "") String ft330Right, 
				@RequestParam(name = "ft660Left", required = false, defaultValue = "") String ft660Left, 
				@RequestParam(name = "ft660Right", required = false, defaultValue = "") String ft660Right, 
				@RequestParam(name = "mph1Left", required = false, defaultValue = "") String mph1Left, 
				@RequestParam(name = "mph1Right", required = false, defaultValue = "") String mph1Right,
				@RequestParam(name = "ft1320Left", required = false, defaultValue = "") String ft1320Left, 
				@RequestParam(name = "ft1320Right", required = false, defaultValue = "") String ft1320Right, 
				@RequestParam(name = "mphLeft", required = false, defaultValue = "") String mphLeft, 
				@RequestParam(name = "mphRight", required = false, defaultValue = "") String mphRight, 
				@RequestParam(name = "firstLeft", required = false, defaultValue = "") String firstLeft, 
				@RequestParam(name = "firstRight", required = false, defaultValue = "") String firstRight,
				@RequestParam(name = "statusLeft", required = false, defaultValue = "") String statusLeft, 
				@RequestParam(name = "statusRight", required = false, defaultValue = "") String statusRight, 
				@RequestParam(name = "fecha", required = false, defaultValue = "") String fecha) {
		  
	    this.template.convertAndSend("/dragtree/race", timeService.save(new Time(entryLeft, entryRight, treespeedLeft, treespeedRight, dialinLeft, 
				dialinRight, reactionLeft, reactionRight, ft60Left, ft60Right, 
				ft330Left, ft330Right, ft660Left, ft660Right, mph1Left, mph1Right, 
				ft1320Left, ft1320Right, mphLeft, mphRight, firstLeft, firstRight, 
				statusLeft, statusRight, fecha)));
	 }
}
