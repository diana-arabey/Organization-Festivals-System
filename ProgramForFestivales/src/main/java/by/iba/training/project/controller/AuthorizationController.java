package by.iba.training.project.controller;

import javax.servlet.http.Cookie;
import by.iba.training.project.controller.MainController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public String authorize(Model model, HttpServletResponse response, @CookieValue(value = "myCookie", required = false) Cookie myCookie, ModelMap map) {
		
		if (myCookie != null) {
			if (myCookie.getValue().equals("REGUSER") || myCookie.getValue().equals("ADMINISTRATOR")) {
				myCookie.setValue("NONREGUSER");
				response.addCookie(myCookie);
				return "redirect:/index";
			}
			
			
		}
		RegInfo reginfo = new RegInfo();
		model.addAttribute("reginfo", reginfo);
				
		return "authorization";
	}
	
	
	@PostMapping("/authorization")
    public ModelAndView eventSubmit(@CookieValue(value = "myCookie", required = false) Cookie myCookie, @CookieValue(value = "myCookieUser", required = false) Cookie myCookieUser,  ModelMap model, HttpServletResponse response, @ModelAttribute RegInfo reginfo) {
	
		boolean flag = false;
		RegInfo reginfoMy = null;
    	for (RegInfo reg : regInfoRepository.findAll()) {
    		if(reginfo.equals(reg)) {
    			flag = true;
    			reginfoMy = reg;
    		}
    	}
    	
    	if(!flag) {
    		return new ModelAndView("redirect:/authorization", model);
    	}   	
    	
//    	Cookie myCookieUser = new Cookie("myCookieUser",Integer.toString( reginfoMy.getUser().getId()));
//    	response.addCookie(myCookieUser);
    	
    	if (myCookie != null) {
			myCookie.setValue("REGUSER");
			response.addCookie(myCookie);
			
		}
    	
    	if (myCookieUser != null) {
			myCookieUser.setValue(Integer.toString( reginfoMy.getUser().getId()));
			response.addCookie(myCookieUser);
		}
    	
        return  new ModelAndView("redirect:/index", model);
        
    }
}
