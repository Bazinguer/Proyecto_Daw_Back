package es.quetepica.api.wrappers;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.entities.User;


public class PetProfileWrapper {

	private Integer id;
	
	@NotNull
	private User user;			
	
	@NotNull
	private String nick;	
	
	@NotNull
	private String sexo;	

	@NotNull
	private String raza;
		
	private String imgProfile;	
	
	@NotNull
	private String description;		

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)		
	private Date petBornDate;	

	public PetProfileWrapper() {

	}

	public PetProfileWrapper(PetProfile petProfile) {
		this.id = petProfile.getId();
		this.user = petProfile.getUser();
		this.nick = petProfile.getNick();
		this.sexo = petProfile.getSexo();
		this.raza = petProfile.getSexo();
		this.imgProfile = petProfile.getImgProfile();
		this.description = petProfile.getDescription();
		this.petBornDate = petProfile.getPetBornDate();
	}


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

	public String getImgProfile() {
		return imgProfile;
	}

	public void setImgProfile(String imgProfile) {
		this.imgProfile = imgProfile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPetBornDate() {
		return petBornDate;
	}

	public void setPetBornDate(Date petBornDate) {
		this.petBornDate = petBornDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PetProfileWrapper{ " +		 		
		"  id='" + this.getId() + '\'' +
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
