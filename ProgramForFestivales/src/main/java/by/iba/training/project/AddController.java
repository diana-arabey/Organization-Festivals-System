package by.iba.training.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.event.PlaceOfEvent;
import by.iba.training.project.repository.EventRepository;
import by.iba.training.project.repository.PlaceRepository;
import by.iba.training.project.repository.UserRepository;

@Controller
public class AddController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping("/addEvent")
    public String addEvent(Model model) {
		placeRepository.deleteAllInBatch();
		eventRepository.deleteAllInBatch();
		Event event =  new Event();
		//event.setId(1);
		event.setCountOfMembers(5);
		event.setName("Rock concert");
		event.setDate("04.05.2018");
		
		PlaceOfEvent place = new PlaceOfEvent("Street Surganova", "Minsk", 15);
		//event.setPlace(place);
		place.setEvent(event);
		event.setPlace(place);
		placeRepository.save(place);
		//eventRepository.save(event);
        model.addAttribute("event", event);
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public String eventSubmit(@ModelAttribute Event event) {
        return "blog";
    }
    
    
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
