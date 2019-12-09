package es.quetepica.api.wrappers;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.entities.Photo;

public class PhotoWrapper {
	
	private Integer id;

	@NotNull	
	private PetProfile petProfile;

	@NotNull	
	private String title;
	
	@NotNull
	private String url;

	private String shortDesciprion;	

	private LocalDateTime creationDate;
	
	public PhotoWrapper() {
		
	}
	
	public PhotoWrapper(Photo photo) {
		this.id = photo.getId();
		this.petProfile = photo.getPetProfile();
		this.title = photo.getTitle();
		this.shortDesciprion = photo.getShortDesciprion();
		this.creationDate = photo.getCreationDate();
		this.url = photo.getUrl();
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		", id='" + this.getId() + '\'' +
		", idPetProfile='" + this.getPetProfile() + '\'' +
		", title='" + this.getTitle() + '\'' +
		", url='" + this.getPetProfile() + '\'' +
		", shortDesciprion='" + this.getShortDesciprion() + '\'' +		 			
		", creationDate='" + this.getCreationDate() + '\'' +
		'}';
	}
}
