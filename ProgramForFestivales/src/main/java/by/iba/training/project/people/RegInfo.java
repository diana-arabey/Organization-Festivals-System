package by.iba.training.project.people;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RegInfo")
public class RegInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_ID")
	private User user;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	    if (obj == this) {
	        return true;
	    }
	    if (obj == null || obj.getClass() != this.getClass()) {
	        return false;
	    }

	    RegInfo reginfo = (RegInfo) obj;
	    return (login == reginfo.login
	            || (login != null &&login.equals(reginfo.getLogin())))        && (password == reginfo.password
	            || (password != null && password .equals(reginfo.getPassword()))
	            );
	    }
	
	
}
 