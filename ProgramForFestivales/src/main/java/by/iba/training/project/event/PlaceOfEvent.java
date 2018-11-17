package by.iba.training.project.event;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "place")
public class PlaceOfEvent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String city;
	@NotNull
	private String adress;
	private int maxAmountOfParticipant;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "place")
	private Event event;
	
	public   PlaceOfEvent (String adress, String city,int maxAmount){
		this.adress = adress;
		this.maxAmountOfParticipant = maxAmount;
		this.city = city;
	//	this.id = 1;
		
	}
	
	public   PlaceOfEvent (){
		
	}
	
	
	
	public void setAmount(int t) {
		maxAmountOfParticipant = t;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getAdress()
	{
		return adress;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

////	 @Id
//	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxAmountOfParticipant() {
		return maxAmountOfParticipant;
	}

	public void setMaxAmountOfParticipant(int maxAmountOfParticipant) {
		this.maxAmountOfParticipant = maxAmountOfParticipant;
	}
//	@OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "place_id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
 