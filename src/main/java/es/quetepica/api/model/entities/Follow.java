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
@Table (name= "follows")
public class Follow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="follow_id")
	private Integer id;	

	@ManyToOne
	@JoinColumn(name="petprofile_id")
	private PetProfile petprofile;
	
	@Column(name="petprofilefollowed_id")
	private Integer followed;
		
	private LocalDateTime creationDate;
	
	public Follow() {
		this.creationDate = LocalDateTime.now();
	}	
	
	public Follow(PetProfile petprofile, Integer followedId) {	
		this();
		this.petprofile = petprofile;
		this.followed = followedId;
	}
		

	public Follow(Integer id, PetProfile petprofile, Integer followed, LocalDateTime creationDate) {	
		this.id = id;
		this.petprofile = petprofile;
		this.followed = followed;
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PetProfile getFollowid() {
		return petprofile;
	}

	public void setFollowid(PetProfile petprofile) {
		this.petprofile = petprofile;
	}

	public Integer getFollowedid() {
		return followed;
	}

	public void setFollowedid(Integer followedid) {
		this.followed = followedid;
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
		 			", idFollow='" + this.getFollowid()+ '\'' +
		 			", idFollowed='" + this.getFollowedid()+ '\'' +
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
	
	
}
