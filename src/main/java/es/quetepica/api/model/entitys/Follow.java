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
@Table (name= "follows")
public class Follow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private Integer idFollow;
	
	private Integer idFollowed;
	
	private boolean favorite;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime creationDate;		
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFollow() {
		return idFollow;
	}

	public void setIdFollow(Integer idFollow) {
		this.idFollow = idFollow;
	}

	public Integer getIdFollowed() {
		return idFollowed;
	}

	public void setIdFollowed(Integer idFollowed) {
		this.idFollowed = idFollowed;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
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
		 			", idFollow='" + this.getIdFollow()+ '\'' +
		 			", idFollowed='" + this.getIdFollowed()+ '\'' +
		 			", favorite='" + this.isFavorite() + '\'' +		 			
		 			", creationDate='" + this.getCreationDate() + '\'' +
					'}';
	}
	
	
}
