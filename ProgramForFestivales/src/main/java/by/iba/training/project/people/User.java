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
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String number;
	private String mail;
	
	//private RegInfo reginfo;
	

	
	public User ()
	{
	
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


//	public RegInfo getReginfo() {
//		return reginfo;
//	}
//
//
//	public void setReginfo(RegInfo reginfo) {
//		this.reginfo = reginfo;
//	}
	
	
}
