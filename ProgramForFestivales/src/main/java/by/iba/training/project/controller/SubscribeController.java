package by.iba.training.project.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.iba.training.project.event.Event;
import by.iba.training.project.event.PlaceOfEvent;
import by.iba.training.project.people.RegInfo;
import by.iba.training.project.people.User;
import by.iba.training.project.repository.ContInfoRepository;
import by.iba.training.project.repository.EventRepository;
import by.iba.training.project.repository.PlaceRepository;
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
	@Autowired
	private PlaceRepository placeRepository;
	
	@PostMapping(value = "/subscribe", params="submit=subscribe")
    public String subscribe(@ModelAttribute Event event,Model model,  HttpServletRequest response) {
		
//		User user =  userRepository.findById(1).get();
//		System.out.println(user.getConinfo().getSurname());
//		
//		Event event = eventRepository.findById(1).get();
//		event.getUsers().add(user);
//		user.getListOfEvent().add(event);
//		userRepository.save(user);
//		eventRepository.save(event);
		
		Event event1 = eventRepository.findById(event.getId()).get();
		System.out.println(event1.getName());
//		for(User us : event1.getUsers()) {
//			System.out.println(us.getConinfo().getSurname());
//		}
		return "index";
	}
	
	@PostMapping(value = "/subscribe", params="submit=delete")
    public String delete(@ModelAttribute Event event,Model model,  HttpServletRequest response) {
		
//		User user =  userRepository.findById(1).get();
//		System.out.println(user.getConinfo().getSurname());
//		
//		Event event = eventRepository.findById(1).get();
//		event.getUsers().add(user);
//		user.getListOfEvent().add(event);
//		userRepository.save(user);
//		eventRepository.save(event);
		System.out.println("re");
		Event event1 = eventRepository.findById(event.getId()).get();
		if (event1.getPerformers() != null) {
		event1.getPerformers().remove(event1);
		}
		
		if (event1.getUsers() != null) {
			event1.getUsers().remove(event1);
			}
		PlaceOfEvent place = event1.getPlace();
		
		
		eventRepository.delete(event1);
		
		if (place != null) {
			placeRepository.delete(place);
		}
		
//		for(User us : event1.getUsers()) {
//			System.out.println(us.getConinfo().getSurname());
//		}
		return "index";
	}
}
