package by.iba.training.project.people;

import java.security.InvalidParameterException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class UserInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	/*private String surname;
	private String firstname;
	private int  age;
	*/private String number;
	private String mail;
	
	//private RegInfo reginfo;
	

	
/*	public UserInfo (String surn, String name, int age)
	{
		this.surname = surn;
		this.firstname = name;
		this.age = age ;

	}
	
	*/public UserInfo ()

	{
	
	}
	
/*	public String getName () {
		return firstname;
	}
	
	public void setName (String firstname) {
		this.firstname = firstname;
	}
	
	public String getSecondName () {
		return surname;
	}
	
	public void setSecondName (String surname) {
		this.surname = surname;
	}
	
	
*/	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setNumber(String str) {
		
		//Pattern pattern = Pattern.compile("^375[0-9]{9}");
		//Matcher m = pattern.matcher(str);
		//if (m.matches() == true) {
			this.number = str;
		//}
		//else throw new InvalidParameterException("Not correct number");
		
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setMail(String str) {
		//Pattern pattern = Pattern.compile("^[a-zA-Z]*@[a-zA-Z]*.[a-z]{2,3}");
		//Matcher m = pattern.matcher(str);
		//if (m.matches() == true) {
			this.mail = str;
		//}
		//else throw new InvalidParameterException("Mail is not correct");
		
		
	}
	
	public String getMail() {
		return mail;
	}
	
	
}
