package by.iba.training.project.people;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import by.iba.training.project.event.Event;


@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
	private String mail;
	private PersonRole role;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
	private ContactInfo coninfo;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
	private RegInfo reginfo;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "user_has_Event",
            joinColumns = { @JoinColumn(name = "user_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Event_ID") })
	private List<Event> listOfEvent;

	
	public User ()
	{
	
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public PersonRole getRole() {
		return role;
	}



	public void setRole(PersonRole role) {
		this.role = role;
	}



	public ContactInfo getConinfo() {
		return coninfo;
	}



	public void setConinfo(ContactInfo coninfo) {
		this.coninfo = coninfo;
	}



	public RegInfo getReginfo() {
		return reginfo;
	}



	public void setReginfo(RegInfo reginfo) {
		this.reginfo = reginfo;
	}



	public List<Event> getListOfEvent() {
		return listOfEvent;
	}



	public void setListOfEvent(List<Event> listOfEvent) {
		this.listOfEvent = listOfEvent;
	}




	
	
}
