package es.quetepica.api.model.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String username;	
	
	private String email;
	
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate bornDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime registrationDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<PetProfile> petProfile;

	public User() {
		this.registrationDate = LocalDateTime.now();
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

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
		
	public Set<PetProfile> getPetProfile() {
		return petProfile;
	}

	public void setPetProfile(Set<PetProfile> petProfiles) {
		this.petProfile = petProfiles;
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
		 			", petProfile=" + this.getPetProfile() +
					'}';
	}
	
	
}
