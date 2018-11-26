package by.iba.training.project.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import by.iba.training.project.event.Event;
import by.iba.training.project.event.KindOfEvents;
import by.iba.training.project.event.PlaceOfEvent;
import by.iba.training.project.people.ContactInfo;
import by.iba.training.project.people.Performer;
import by.iba.training.project.people.User;
import by.iba.training.project.repository.ContInfoRepository;
import by.iba.training.project.repository.EventRepository;
import by.iba.training.project.repository.PerformerRepository;
import by.iba.training.project.repository.PlaceRepository;
import by.iba.training.project.repository.UserRepository;

@Controller
public class EventController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private PerformerRepository performerRepository;
	@Autowired
	private ContInfoRepository contInfoRepository;
	
	
	@GetMapping("/addEvent")
    public String addEvent(Model model) {
		
		List<Performer> performerList = new ArrayList<Performer>();
		List<ContactInfo> listcont = new ArrayList<ContactInfo>();
		for(Performer perf : performerRepository.findAll()) {
			//System.out.println();
			performerList.add(perf);
			
		}	
		model.addAttribute("list", performerList);
		
		
		Event event =  new Event();
		PlaceOfEvent place = new PlaceOfEvent();
		String kind ="" ;
		model.addAttribute("kind", kind);
        model.addAttribute("event",event);
        model.addAttribute("place", place);

        return "addEvent";
    }
	
	

    @PostMapping("/addEvent")
    public String eventSubmit(@ModelAttribute Event event, Model model, HttpServletRequest response, @ModelAttribute PlaceOfEvent place) {
    	//event.setKindOfEvent(KindOfEvents.valueOf(response.getParameter("kind").toUpperCase()));
    	
    	List<Performer> listPerformer = event.getPerformers();
    	for(Performer per: listPerformer) {
    		per.getListOfEvent().add(event);
    	}
    	
    	event.setCountOfMembers(0);		
    	place.setEvent(event);
		event.setPlace(place);
		
		placeRepository.save(place);
		eventRepository.save(event);
    	showBlog(model);
        return "/blog";
    }
    
    @GetMapping("/blog")
	public String showBlog(Model model) {
    
    	return "blog";
    }
    

   
    
    
  

	/*@PostMapping("/createuser")
	public ModelAndView createUser(@Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form.");
			modelAndView.setViewName("createuser");
			modelAndView.addObject("user", user);
			modelAndView.addObject("allProfiles", getProfiles());
			return modelAndView;
		}
		userService.addUser(user);
		modelAndView.addObject("allUsers", userService.getAllUsers());
		modelAndView.setViewName("new");
		logger.info("Form submitted successfully.");
		return modelAndView;
	}
   */
    
    
  //  @RequestMapping(path = "/addEvent") 
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
	
}
