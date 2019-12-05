package es.quetepica.api.model.entitys;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="pet_profiles")
public class PetProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	@ManyToOne
	@JoinColumn(name="users_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;	
	
	private String nick;
	
	private String sexo;
	
	private String raza;	
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate petBornDate;	
	
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNick() {
		return nick;
	}	

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public LocalDate getPetBornDate() {
		return petBornDate;
	}

	public void setPetBornDate(LocalDate petBornDate) {
		this.petBornDate = petBornDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PetProfile{ " +
		 			"id='" + this.getId() + '\'' +
		 			", User='" + this.getUser()+ '\'' +
		 			", nick='" + this.getNick() + '\'' +
		 			", sexo='" + this.getSexo() + '\'' +
		 			", raza='" + this.getRaza() + '\'' +
		 			", petBornDate='" + this.getPetBornDate() + '\'' +
		 			", description=" + this.getDescription() +
					'}';
	}
}
