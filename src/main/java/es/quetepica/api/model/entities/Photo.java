package es.quetepica.api.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "photo_id")
	private int id;	

	@ManyToOne
	@JoinColumn(name="pet_profile_id")	
	private PetProfile petprofile;

	private String title;

	private String short_desciprion;	

	@Column(name="creation_date")
	private LocalDateTime creationDate;	

	private String url;

	public Photo() {
		this.creationDate = LocalDateTime.now();

	}	
	
	public Photo(PetProfile petProfile,String url ,String title, String shortDesciprion) {
		this();
		this.petprofile = petProfile;
		this.url = url;
		this.title = title;
		this.short_desciprion = shortDesciprion;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PetProfile getPetProfile() {
		return petprofile;
	}

	public void setPetProfile(PetProfile petProfile) {
		this.petprofile = petProfile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDesciprion() {
		return short_desciprion;
	}

	public void setShortDesciprion(String shortDesciprion) {
		this.short_desciprion = shortDesciprion;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Photo{ " +
		"id='" + this.getId() + '\'' +
		"url='" + this.getUrl() + '\'' +
		", idPetProfile='" + this.getPetProfile() + '\'' +
		", title='" + this.getTitle() + '\'' +
		", shortDesciprion='" + this.getShortDesciprion() + '\'' +		 			
		", creationDate='" + this.getCreationDate() + '\'' +
		'}';
	}

}
