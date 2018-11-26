package by.iba.training.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.people.RegInfo;
import by.iba.training.project.people.User;
import by.iba.training.project.repository.ContInfoRepository;
import by.iba.training.project.repository.EventRepository;
import by.iba.training.project.repository.RegInfoRepository;
import by.iba.training.project.repository.UserRepository;

@Controller
public class SubscribeController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContInfoRepository contInfoRepository;
	@Autowired
	private RegInfoRepository regInfoRepository;
	@Autowired
	private EventRepository eventRepository;
	
	@PostMapping("/subscribe")
    public String subscribe(Model model) {
		
		User user =  userRepository.findById(1).get();
		System.out.println(user.getConinfo().getSurname());
		
		Event event = eventRepository.findById(1).get();
		event.getUsers().add(user);
		user.getListOfEvent().add(event);
		userRepository.save(user);
		eventRepository.save(event);
		
		Event event1 = eventRepository.findById(1).get();
		for(User us : event1.getUsers()) {
			System.out.println(us.getConinfo().getSurname());
		}
		return "index";
	}
}
