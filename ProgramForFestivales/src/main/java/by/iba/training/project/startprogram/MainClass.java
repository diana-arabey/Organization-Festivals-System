package by.iba.training.project.startprogram;




import java.sql.SQLException;



import java.util.LinkedList;
/*
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import by.iba.training.project.event.Event;
import by.iba.training.project.event.PlaceOfEvent;
import by.iba.training.project.myexceptions.ExceptionCountOfParticipant;
import by.iba.training.project.people.Participant;
import by.iba.training.project.people.UserInfo;


public class MainClass {

	public static void start() {
		LinkedList<PlaceOfEvent> listPlaces  = new  LinkedList<PlaceOfEvent> ();
		
		// Connect to DB with JDBC
	/*	Connector connector=new Connector("localhost","mydb","root","diana2018");
		
		try {
			connector.openConnection();
			System.out.println("Connected successfully");
		}catch(SQLException | ClassNotFoundException e ) {
			System.out.println("Error1 " + e.getMessage());
		}
	

	scope maven
		
		try {
			//connector.writePlace(new PlaceOfEvent("address some1", "Minsk",23));
			//connector.writePlace(new PlaceOfEvent("address some2", "Vitebsk",2));
			//connector.writePlace(new PlaceOfEvent("address some3", "Gomel",173));
			listPlaces = (LinkedList<PlaceOfEvent>) connector.readPlaces();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		for (PlaceOfEvent place1 : listPlaces) {
			System.out.println("City: "+ place1.getCity() +" Address: "+ place1.getAdress() +" Max amount of participants:  "+ place1.getMaxAmountOfParticipan());
		}
		rest api service
		
	*/
		
		SessionFactory sesFact = HibernateUtility.getSessionFactory();
		if (sesFact == null) {
			System.out.println("Null");
		}
		else {
		Session session = sesFact.openSession();
		session.beginTransaction();
		
		PlaceOfEvent place = new PlaceOfEvent();
		place.setAdress("some address new1");
		place.setAmount(28);
		place.setCity("Minsk");
		session.save(place);
		session.getTransaction().commit();;
		sesFact.close();
		HibernateUtility.getSessionFactory().close();
		}

		
		
		 //add 5 users
	/*	Event festival = new Event();
		Participant participant =  new Participant(new UserInfo("Ivanov","Ivan",23 ));
		for (int i= 1; i<=6 ; i++) {
		
			try {
			festival.addParticipant(participant);
			}
			catch (ExceptionCountOfParticipant e) {
				System.out.println(e.getMessage());
			}
		}
	*/	
		
	}
	

}
