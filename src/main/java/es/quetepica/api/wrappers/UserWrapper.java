package es.quetepica.api.wrappers;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import es.quetepica.api.model.entities.User;

public class UserWrapper {
	
	private int id;
	
	@NotNull
	private String username;	

	private String email;
	
	@NotNull
	private String password;	

	private LocalDate bornDate;

	public UserWrapper() {

	}
	
	public UserWrapper(int id, String email) {	
		this.id = id;
		this.email = email;		
	}

	public UserWrapper(String username, String email, String password, LocalDate bornDate) {	
		this.username = username;
		this.email = email;
		this.password = password;
		this.bornDate = bornDate;
	}


	public UserWrapper(User user) {
		this.id = user.getId();
		this.username = user.getUsername();	
		this.email = user.getEmail();
		this.password = user.getPassword();		
		this.bornDate = user.getBornDate();		
			
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}	
	
	@Override
	public String toString() {
		
		return "UserWrapper{" +    
				", id='" + this.getId() + '\'' +
                ", userName='" + this.getUsername() + '\'' +
                ", email='" + this.getEmail() + '\'' + 
                ", pass='" + this.getPassword() + '\'' + 
                ", bornDate='" + this.getBornDate() + '\'' +                   
                '}';
	}	
	

}
