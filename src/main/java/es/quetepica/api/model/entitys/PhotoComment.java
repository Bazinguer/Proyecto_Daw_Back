package es.quetepica.api.model.entitys;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "photo_comments")
public class PhotoComment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private Integer idPhoto;
	
	private Integer idPetProfile;
	
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime creationDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}

	public Integer getIdPetProfile() {
		return idPetProfile;
	}

	public void setIdPetProfile(Integer idPetProfile) {
		this.idPetProfile = idPetProfile;
	}

	public String getComent() {
		return comment;
	}

	public void setComent(String coment) {
		this.comment = coment;
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
		 			", idPhoto='" + this.getIdPhoto() + '\'' +
		 			", idPetProfile='" + this.getIdPetProfile() + '\'' +
		 			", coment='" + this.getComent() + '\'' +		 		
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}	
	
	
}