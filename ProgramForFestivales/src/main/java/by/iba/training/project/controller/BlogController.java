package by.iba.training.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.repository.EventRepository;
import by.iba.training.project.repository.PlaceRepository;

@Controller
public class BlogController {
	
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private EventRepository eventRepository;
	
	@PostMapping("/blogView")
	public String showViewBlog(@ModelAttribute Event prod, Model model, HttpServletRequest response) {
		
		
		Event event  = eventRepository.findById(prod.getId()).get();
		model.addAttribute("event", event);
    	return "blog";
    }
}
