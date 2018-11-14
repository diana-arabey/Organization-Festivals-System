package by.iba.training.project.event;

import java.util.Date;
import java.util.List;

import by.iba.training.project.myexceptions.ExceptionCountOfParticipant;
import by.iba.training.project.people.Participant;
import by.iba.training.project.people.Performer;


public class Event {

	private int id;
	private String name;
	private Date date;
	private int countOfMembers;
	private String description;
	private List<Participant> participants;
    private List<Performer> performers;
	private PlaceOfEvent place;
	private KindOfEvents kindOfEvent;
	
	
	public Event () {
		this.id = 1;
		this.name = "MusicFest";
		this.place = new PlaceOfEvent("Street Surganova", "Minsk", 15);
	}
	
	
	public void setId (int id)
	{
		this.id = id;
	}
	
	public int getId () {
		return this.id;
	}
	
	public void setName (String name)
	{
		this.name =name;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setDate (Date date)
	{
		this.date =  date;
	}
	
	public Date getDate () {
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
		this.place = place;
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


	public List<Participant> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}


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


	public PlaceOfEvent getPlace() {
		return place;
	}


	public void setCountOfMembers(int countOfMembers) {
		this.countOfMembers = countOfMembers;
	}
	
	
}
