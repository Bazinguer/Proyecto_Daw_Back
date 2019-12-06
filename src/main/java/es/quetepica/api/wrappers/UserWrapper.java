package es.quetepica.api.wrappers;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import es.quetepica.api.model.entities.User;

public class UserWrapper {	

	private Integer id;
	
	@NotNull
	private String username;	

	@NotNull	
	private String email;
	
	@NotNull
	private String password;	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)	
	private Date bornDate;

	public UserWrapper() {

	}
	
	public UserWrapper(Integer id, String email) {	
		this.id = id;
		this.email = email;		
	}

	public UserWrapper(String username, String email, String password, Date bornDate) {	
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
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
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
