package by.iba.training.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.event.KindOfEvents;
import by.iba.training.project.event.PlaceOfEvent;
import by.iba.training.project.people.ContactInfo;
import by.iba.training.project.people.Performer;
import by.iba.training.project.people.PerformerType;
import by.iba.training.project.repository.ContInfoRepository;
import by.iba.training.project.repository.PerformerRepository;
import by.iba.training.project.repository.PlaceRepository;
import by.iba.training.project.repository.UserRepository;

@Controller
public class PerformerController {

	@Autowired
	private ContInfoRepository coninfoRepository;
	
	@Autowired
	private PerformerRepository performerRepository;
	
	@GetMapping("/addPerformer")
    public String addPerformer(Model model) {
		
		
		Performer performer =  new Performer();
		ContactInfo continfo = new ContactInfo();
		String type ="" ;
		model.addAttribute("type", type);
        model.addAttribute("performer",performer);
        model.addAttribute("continfo", continfo);
        return "addPerformer";
    }
	
	
	 @PostMapping("/addPerformer")
	    public String eventSubmit(@ModelAttribute Performer performer, Model model, HttpServletRequest response, @ModelAttribute ContactInfo coninfo) {
		 	performer.setType(PerformerType.valueOf(response.getParameter("type").toUpperCase()));
		 	performer.setConifo(coninfo);
		 	coninfo.setPerformer(performer);
		 	performerRepository.save(performer);
	    	
	        return "index";
	    }
	 
	 
}
