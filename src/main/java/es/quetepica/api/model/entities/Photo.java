package es.quetepica.api.model.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pet_profile_id")	
	private PetProfile petProfile;
		
	private String title;
	
	private String shortDesciprion;	
	
	@Column(name="creation_date")
	private LocalDateTime creationDate;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PetProfile getPetProfile() {
		return petProfile;
	}

	public void setPetProfile(PetProfile petProfile) {
		this.petProfile = petProfile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDesciprion() {
		return shortDesciprion;
	}

	public void setShortDesciprion(String shortDesciprion) {
		this.shortDesciprion = shortDesciprion;
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
		 			", idPetProfile='" + this.getPetProfile() + '\'' +
		 			", title='" + this.getTitle() + '\'' +
		 			", shortDesciprion='" + this.getShortDesciprion() + '\'' +		 			
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
	
}
