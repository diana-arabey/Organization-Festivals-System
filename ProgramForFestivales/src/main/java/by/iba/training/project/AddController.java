package by.iba.training.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;

@Controller
public class AddController {

	
	@GetMapping("/addEvent")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public String eventSubmit(@ModelAttribute Event event) {
        return "blog.html";
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
