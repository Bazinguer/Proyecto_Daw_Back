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
@Table (name= "follows")
public class Follow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="follow_id")
	private int id;	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pet_profile_id")
	private PetProfile pet_profile_follow_id;
	
	@Column(name="pet_profile_followed_id")
	private int petFollowed;
		
	private LocalDateTime creationDate;
	
	public Follow() {
		this.creationDate = LocalDateTime.now();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PetProfile getPetFollow() {
		return pet_profile_follow_id;
	}

	public void setPetFollow(PetProfile petFollow) {
		this.pet_profile_follow_id = petFollow;
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
		return "Follow{ " +
		 			"id='" + this.getId() + '\'' +
		 			", idFollow='" + this.getPetFollow()+ '\'' +
		 			", idFollowed='" + this.getPetFollowed()+ '\'' +
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
	
	
}
