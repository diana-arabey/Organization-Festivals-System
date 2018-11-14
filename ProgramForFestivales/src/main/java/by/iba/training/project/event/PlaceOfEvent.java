package by.iba.training.project.event;

public class PlaceOfEvent {
	private int id;
	private String city;
	private String adress;
	private int maxAmountOfParticipant;
	
	public   PlaceOfEvent (String adress, String city,int maxAmount){
		this.adress = adress;
		this.maxAmountOfParticipant = maxAmount;
		this.city = city;
	}
	
	public   PlaceOfEvent (){
		
	}
	
	public int getMaxAmountOfParticipan()
	{
		return maxAmountOfParticipant;
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
}
 