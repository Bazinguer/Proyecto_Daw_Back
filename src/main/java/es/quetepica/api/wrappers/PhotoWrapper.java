package es.quetepica.api.wrappers;

import java.time.LocalDateTime;

import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.entities.Photo;

public class PhotoWrapper {

	private PetProfile petProfile;

	private String title;

	private String shortDesciprion;	

	private LocalDateTime creationDate;
	
	public PhotoWrapper() {
		
	}
	
	public PhotoWrapper(Photo photo) {
		this.petProfile = photo.getPetProfile();
		this.title = photo.getTitle();
		this.shortDesciprion = photo.getShortDesciprion();
		this.creationDate = photo.getCreationDate();
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
		return "PhotoWrapper{ " +	
		", idPetProfile='" + this.getPetProfile() + '\'' +
		", title='" + this.getTitle() + '\'' +
		", shortDesciprion='" + this.getShortDesciprion() + '\'' +		 			
		", creationDate='" + this.getCreationDate() + '\'' +
		'}';
	}
}
