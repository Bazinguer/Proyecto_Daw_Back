package es.quetepica.api.model.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "user_id")
	private Integer id;	
	
	private String username;		
	
	@Column(unique = true)
	private String email;
	
	private String password;	

	@Column(name= "born_date")
	private Date bornDate;
		
	@Column(name= "registration_date")
	private LocalDateTime registrationDate;

	public User() {
		this.registrationDate = LocalDateTime.now();
	}
	
	public User(String username, String email, String password, Date bornDate) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.bornDate = bornDate;
		this.registrationDate = LocalDateTime.now();
	}

/*	public User(UserWrapper userWrapper) {		
		this.username = userWrapper.getUsername();
		this.email = userWrapper.getEmail();
		this.password = userWrapper.getPassword();
		this.bornDate = userWrapper.getBornDate();		
	}
*/

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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
		

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User{ " +
		 			"id='" + this.getId() + '\'' +
		 			", username='" + this.getUsername() + '\'' +
		 			", email='" + this.getEmail() + '\'' +
		 			", password='" + this.getPassword() + '\'' +
		 			", bornDate='" + this.getBornDate() + '\'' +
		 			", registrationDate=" + this.getRegistrationDate() +
		 	//		", petProfile=" + this.getPetProfile() +
					'}';
	}
	
	
}
