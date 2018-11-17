package by.iba.training.project;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.iba.training.project.event.Event;
import by.iba.training.project.people.UserInfo;



@Controller    

public class MainController {
	//@Autowired 
	           
	

	
	@GetMapping("/index") 
    public String index() {
		
        return "index";
    }
	
//	@RequestMapping(path = "/addEvent") 
//	public  String addEvent () {
		
//		UserInfo n = new UserInfo();
//		n.setID(id);
//		n.setNumber(number);
//		n.setMail(mail);
//		userRepository.save(n);
		
//		return "/addEvent.html";
	//}
//	
//	@RequestMapping(path = "/blog") 
//	public  String blog () {
//		
//		return "/blog.html";
//	}
//	
//	@RequestMapping(value = "/blog.html", method = RequestMethod.POST) 
//	public  String saveEvent (Model model, HttpServletRequest request) {
//		String name = request.getParameter("name");
//		model.addAttribute("name", name);
//		return "/blog.html";
//	}
	
//	 @RequestMapping(value = "/greeting",  method = RequestMethod.GET)
//	    public String greetingForm(Model model) {
//	        model.addAttribute("greeting", new Greeting());
//	        return "greeting";
//	    }
//
//	    @RequestMapping(value = "/greeting.html", method = RequestMethod.POST)
//	    public String greetingSubmit(@ModelAttribute Greeting greeting) {
//	        return "/result.html";
//	    }

//	    @GetMapping( "/greeting")
//	    public String greetingForm(Model model) {
//	        model.addAttribute("greeting", new Greeting());
//	        return "greeting";
//	    }
//
//	    @PostMapping( "/greeting")
//	    public String greetingSubmit(@ModelAttribute Greeting greeting) {
//	        return "result";
//	    }
	
	
	 
//	@GetMapping(path="/add") 
//	public @ResponseBody String addNewUser (@RequestParam int id, @RequestParam String number
//			, @RequestParam String mail) {
//		
//		UserInfo n = new UserInfo();
//		n.setID(id);
//		n.setNumber(number);
//		n.setMail(mail);
//		userRepository.save(n);
//		return "Saved";
//	}
//	
//	@GetMapping(path="/all")
//	public @ResponseBody Iterable<UserInfo> getAllUsers() {
//	
//		return userRepository.findAll();
//	}
}
