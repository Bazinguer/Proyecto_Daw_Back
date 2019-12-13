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
@Table(name = "photo_comments")
public class PhotoComment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int id;	
	
	@ManyToOne
	@JoinColumn(name="photo_id")	
	private Photo photo;
	
	@ManyToOne
	@JoinColumn(name="pet_profile_id")	
	private PetProfile petProfile;
	
	@Column(name="text_comment")
	private String comment;
		
	@Column(name="creation_date")
	private LocalDateTime creationDate;

	public PhotoComment() {
		this.creationDate = LocalDateTime.now();
	}
		
		
	public PhotoComment(Photo photo, PetProfile petProfile, String comment) {		
		this();
		this.photo = photo;
		this.petProfile = petProfile;
		this.comment = comment;		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "PhotoComent{ " +
		 			"id='" + this.getId() + '\'' +
		 			", idPhoto='" + this.getPhoto() + '\'' +
		 			", idPetProfile='" + this.getPetProfile()+ '\'' +
		 			", coment='" + this.getComment() + '\'' +		 		
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}	
	
	
}
