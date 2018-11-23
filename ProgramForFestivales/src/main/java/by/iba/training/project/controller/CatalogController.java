package by.iba.training.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.repository.EventRepository;

@Controller
public class CatalogController {

	
	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping("/catalog")
    public String showCatalog(Model model) {
		
		List<Event> listEvent = new ArrayList<Event>();
		for(Event ev : eventRepository.findAll()) {
			listEvent.add(ev);
		}	
		model.addAttribute("list", listEvent);
		model.addAttribute("flag", "novisible");
		return "catalog";
	}
}
