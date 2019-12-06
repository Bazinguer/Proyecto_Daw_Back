package es.quetepica.api.wrappers;

import java.time.LocalDateTime;

import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.entities.Photo;
import es.quetepica.api.model.entities.PhotoComment;

public class PhotoCommentWrapper {

	private Photo photo;

	private PetProfile petProfile;
	
	private String comment;

	private LocalDateTime creationDate;
	
	public PhotoCommentWrapper() {
		
	}
	
	public PhotoCommentWrapper(PhotoComment photoComment) {
		this.photo = photoComment.getPhoto();
		this.petProfile = photoComment.getPetProfile();
		this.comment = photoComment.getComment();
		this.creationDate = photoComment.getCreationDate();
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
		 			", idPhoto='" + this.getPhoto() + '\'' +
		 			", idPetProfile='" + this.getPetProfile()+ '\'' +
		 			", coment='" + this.getComment() + '\'' +		 		
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}	
	
}
