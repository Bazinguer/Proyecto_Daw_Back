package es.quetepica.api.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="pet_profiles")
public class PetProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "pet_profile_id")
	private Integer id;	

	@ManyToOne
	@JoinColumn(name="user_id")	
	@NotNull 
	private User user;	

	@Column(unique = true)
	@NotNull 
	private String nick;

	private String sexo;

	private String raza;	

	@Column(name= "img_profile")
	private String imgProfile;

	private String description;	

	@Column(name= "pet_borndate")
	private Date petBornDate;

	public PetProfile() {		

	}	
	
	public PetProfile(User user, String nick,String description) {		
		this.user = user;
		this.nick = nick;	
		this.description = description;		
	}	


	public PetProfile(User user, String nick, String sexo, String raza, String imgProfile,
			String description, Date petBornDate) {		
		this.user = user;
		this.nick = nick;
		this.sexo = sexo;
		this.raza = raza;
		this.imgProfile = imgProfile;
		this.description = description;
		this.petBornDate = petBornDate;
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

	public Date getPetBornDate() {
		return petBornDate;
	}

	public void setPetBornDate(Date petBornDate) {
		this.petBornDate = petBornDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgProfile() {
		return imgProfile;
	}

	public void setImgProfile(String imgProfile) {
		this.imgProfile = imgProfile;
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
		", imgProfile=" + this.getImgProfile() +
		'}';
	}
}
