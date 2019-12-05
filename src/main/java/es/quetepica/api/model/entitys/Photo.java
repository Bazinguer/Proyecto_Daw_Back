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
@Table(name = "photos")
public class Photo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	
	private Integer idPetProfile;
		
	private String title;
	
	private String shortDesciprion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime creationDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPetProfile() {
		return idPetProfile;
	}

	public void setIdPetProfile(Integer idPetProfile) {
		this.idPetProfile = idPetProfile;
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
		return "Photo{ " +
		 			"id='" + this.getId() + '\'' +
		 			", idPetProfile='" + this.getIdPetProfile() + '\'' +
		 			", title='" + this.getTitle() + '\'' +
		 			", shortDesciprion='" + this.getShortDesciprion() + '\'' +		 			
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
	
}
