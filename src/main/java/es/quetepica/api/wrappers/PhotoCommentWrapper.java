package es.quetepica.api.wrappers;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.entities.Photo;
import es.quetepica.api.model.entities.PhotoComment;

public class PhotoCommentWrapper {
	
	private Integer id;
	
	@NotNull
	private Photo photo;
	
	@NotNull
	private PetProfile petProfile;
	
	@NotNull
	private String comment;

	private LocalDateTime creationDate;
	
	public PhotoCommentWrapper() {
		
	}
	
	public PhotoCommentWrapper(PhotoComment photoComment) {
		this.id = photoComment.getId();
		this.photo = photoComment.getPhoto();
		this.petProfile = photoComment.getPetProfile();
		this.comment = photoComment.getComment();
		this.creationDate = photoComment.getCreationDate();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public PetProfile getPetProfile() {
		return petProfile;
	}

	public void setPetProfile(PetProfile petProfile) {
		this.petProfile = petProfile;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "PhotoComentWrapper{ " +		 	
				    ", id ='" + this.getId()+ '\'' +
		 			", idPhoto='" + this.getPhoto() + '\'' +
		 			", idPetProfile='" + this.getPetProfile()+ '\'' +
		 			", coment='" + this.getComment() + '\'' +		 		
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}	
	
}
