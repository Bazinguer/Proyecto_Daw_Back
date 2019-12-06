package es.quetepica.api.wrappers;

import java.time.LocalDateTime;

import es.quetepica.api.model.entities.Follow;
import es.quetepica.api.model.entities.PetProfile;

public class FollowWrapper {

	private PetProfile petFollow;

	private int petFollowed;
	
	private LocalDateTime creationDate;
	
	public FollowWrapper() {
		
	}
	
	public FollowWrapper(Follow follow) {		
		this.petFollow = follow.getPetFollow();
		this.petFollowed = follow.getPetFollowed();		
		this.creationDate = follow.getCreationDate();
	}

	public PetProfile getPetFollow() {
		return petFollow;
	}

	public void setPetFollow(PetProfile petFollow) {
		this.petFollow = petFollow;
	}

	public int getPetFollowed() {
		return petFollowed;
	}

	public void setPetFollowed(int petFollowed) {
		this.petFollowed = petFollowed;
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
		return "FollowWrapper{ " +		 		
		 			", idFollow='" + this.getPetFollow()+ '\'' +
		 			", idFollowed='" + this.getPetFollowed()+ '\'' +
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
}
