package by.iba.training.project.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.event.PlaceOfEvent;
import by.iba.training.project.people.ContactInfo;
import by.iba.training.project.people.Performer;
import by.iba.training.project.people.PersonRole;
import by.iba.training.project.people.RegInfo;
import by.iba.training.project.people.User;
import by.iba.training.project.repository.ContInfoRepository;
import by.iba.training.project.repository.RegInfoRepository;
import by.iba.training.project.repository.UserRepository;



@Controller
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContInfoRepository contInfoRepository;
	@Autowired
	private RegInfoRepository regInfoRepository;
	
	@GetMapping("/registration")
    public String register(Model model) {
		
		User user = new User();
		ContactInfo coninfo = new ContactInfo();
		RegInfo reginfo = new RegInfo();
		String repeatpassw = "rere";
		user.setRole(PersonRole.REGUSER);
		model.addAttribute("user", user);
		model.addAttribute("coninfo", coninfo);
		model.addAttribute("reginfo", reginfo);
		model.addAttribute("repeatpassw", repeatpassw);
		
		
		return "registration";
	}
	
	 @PostMapping("/registration")
	    public String eventSubmit(@ModelAttribute User user, Model model, HttpServletRequest response, @ModelAttribute RegInfo reginfo, @ModelAttribute ContactInfo coninfo) {
		

	    	if (!response.getParameter("repeatpassw").equals(reginfo.getPassword()))
	    	{
	    		return "registration";
	    	}
	    	
	    	coninfo.setPerformer(null);
		 	user.setConinfo(coninfo);
		 	user.setReginfo(reginfo);
		 	coninfo.setUser(user);
		 	reginfo.setUser(user);
	    
	    	
		 	userRepository.save(user);
	    	contInfoRepository.save(coninfo);
			regInfoRepository.save(reginfo);
			
	        return "/index";
	    }
}
