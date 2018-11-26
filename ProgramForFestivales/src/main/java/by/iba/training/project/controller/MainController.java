package by.iba.training.project.controller;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import by.iba.training.project.event.Event;
import by.iba.training.project.people.PersonRole;
import by.iba.training.project.people.RegInfo;
import by.iba.training.project.people.User;


@Controller    
public class MainController {
	           


	
	@GetMapping("/index") 
    public String indexHttp(@CookieValue(value = "myCookie", required = false) Cookie myCookie, HttpServletResponse response, Model model, @CookieValue(value = "myCookieUser", required = false) Cookie myCookieUser, ModelMap map) {
    	

		if (myCookie == null) {
			myCookie = new Cookie("myCookie","NONREGUSER");
			response.addCookie(myCookie);
		}
		if(myCookieUser ==null) {
			myCookieUser = new Cookie("myCookieUser","0");
			response.addCookie(myCookieUser);
		}
		
		if (myCookie != null) {		
			if (myCookie.getValue().equals("REGUSER") || myCookie.getValue().equals("ADMINISTRATOR")) {
				model.addAttribute("flagLog", "Log out" );
			}
			if (myCookie.getValue().equals("NONREGUSER")) {
				model.addAttribute("flagLog", "Log in" );
			}
		}
		
        return "index";
    }
	


	
}
