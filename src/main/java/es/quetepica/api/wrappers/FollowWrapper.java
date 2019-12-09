package es.quetepica.api.wrappers;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import es.quetepica.api.model.entities.Follow;
import es.quetepica.api.model.entities.PetProfile;

public class FollowWrapper {
	
	private Integer id;

	@NotNull	
	private Integer petFollow;
	
	@NotNull
	private PetProfile petprofile;

	@NotNull
	private Integer petFollowed;
	
	private LocalDateTime creationDate;
	
	public FollowWrapper() {
		
	}
	
	public FollowWrapper(Follow follow) {		
		this.id = follow.getId();
		this.petFollow = follow.getFollowid().getId();
		this.petprofile = follow.getFollowid();
		this.petFollowed = follow.getFollowedid();		
		this.creationDate = follow.getCreationDate();		
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPetFollow() {
		return petFollow;
	}

	public void setPetFollow(Integer petFollow) {
		this.petFollow = petFollow;
	}

	public Integer getPetFollowed() {
		return petFollowed;
	}

	public void setPetFollowed(Integer petFollowed) {
		this.petFollowed = petFollowed;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
		

	public PetProfile getPetprofile() {
		return petprofile;
	}

	public void setPetprofile(PetProfile petprofile) {
		this.petprofile = petprofile;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FollowWrapper{ " +
				    ", id='" + this.getId() + '\'' +
		 			", idFollow='" + this.getPetFollow() + '\'' +
		 			", idFollowed='" + this.getPetFollowed() + '\'' +
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
}
