package by.iba.training.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.people.ContactInfo;
import by.iba.training.project.people.PersonRole;
import by.iba.training.project.people.RegInfo;
import by.iba.training.project.people.User;
import by.iba.training.project.repository.RegInfoRepository;

@Controller
public class AuthorizationController {
	
	
	@Autowired
	private RegInfoRepository regInfoRepository;
	
	@GetMapping("/authorization")
    public String authorize(Model model) {
		
		RegInfo reginfo = new RegInfo();
		model.addAttribute("reginfo", reginfo);
				
		return "authorization";
	}
	
	
	@PostMapping("/authorization")
    public String eventSubmit(Model model, HttpServletRequest response, @ModelAttribute RegInfo reginfo) {
	

    	for (RegInfo reg : regInfoRepository.findAll()) {
    		if(reginfo.equals(reg)) {
    			//roleInUse = PersonRole.REGUSER;
    		}
    	}
	
    	
    	
		
        return "/index";
    }
}
