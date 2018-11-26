package by.iba.training.project.event;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import by.iba.training.project.myexceptions.ExceptionCountOfParticipant;
import by.iba.training.project.people.Participant;
import by.iba.training.project.people.Performer;
import by.iba.training.project.people.User;

@Entity
@Table(name = "Event")
public class Event {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String name;
	private String date;
	private int countOfMembers;
	private String description;
	private KindOfEvents kindOfEvent;
	//private List<Participant> participants;
	
	
	 @ManyToMany(fetch = FetchType.LAZY,
     cascade = {
         CascadeType.PERSIST,
         CascadeType.MERGE
     },
     mappedBy = "listOfEvent")
     private List<Performer> performers;
	
	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "place_ID")
	 private PlaceOfEvent place;
	
	 @ManyToMany(fetch = FetchType.LAZY,
		     cascade = {
		         CascadeType.PERSIST,
		         CascadeType.MERGE
		     },
	 mappedBy = "listOfEvent")
	 private List<User> users;
	
	
	public Event () {
		
	}
	
	
	public void setId (int id)
	{
		this.id = id;
	}
	//@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId () {
		return this.id;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setDate (String date)
	{
		this.date =  date;
	}
	
	public String getDate () {
		return  this.date;
	}
	public void increaseCountOfMembers ()
	{
		this.countOfMembers++;
	}
	
	public int getCountOfMembers () {
		return this.countOfMembers;
	}
	
	public void setPlace (PlaceOfEvent place)
	{
		/*if (place == null) {
            if (this.place != null) {
                this.place.setEvent(null);
            }
        }
        else {
        	place.setEvent(this);
        }
        */this.place = place;
    
	}
	
	public void addParticipant(Participant p ) throws ExceptionCountOfParticipant {
		 if  (countOfMembers >= 5 ) {
			// throw new ExceptionCountOfParticipant("������ �������� ���������");
		 }
		 else {
			// System.out.println("�������� ��������");
			 increaseCountOfMembers();
		 }
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
/*

	public List<Participant> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

*/
	public List<Performer> getPerformers() {
		return performers;
	}


	public void setPerformers(List<Performer> performers) {
		this.performers = performers;
	}


	public KindOfEvents getKindOfEvent() {
		return kindOfEvent;
	}


	public void setKindOfEvent(KindOfEvents kindOfEvent) {
		this.kindOfEvent = kindOfEvent;
	}


	 //@OneToOne(mappedBy = "event")
	public PlaceOfEvent getPlace() {
		return place;
	}


	public void setCountOfMembers(int countOfMembers) {
		this.countOfMembers = countOfMembers;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
