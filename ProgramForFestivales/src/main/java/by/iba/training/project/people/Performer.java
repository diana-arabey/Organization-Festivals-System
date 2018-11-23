package by.iba.training.project.people;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Performer")
public class Performer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	private String profession;
	private String achievement;
	private PerformerType type;
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "performer")
	private ContactInfo conifo;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public List<Event> getListOfEvent() {
//		return listOfEvent;
//	}
//	public void setListOfEvent(List<Event> listOfEvent) {
//		this.listOfEvent = listOfEvent;
//	}
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	
	public PerformerType getType() {
		return type;
	}
	public void setType(PerformerType type) {
		this.type = type;
	}
	public ContactInfo getConifo() {
		return conifo;
	}
	public void setConifo(ContactInfo conifo) {
		this.conifo = conifo;
	}
	
	
	
}
