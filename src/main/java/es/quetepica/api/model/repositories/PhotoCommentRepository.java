package es.quetepica.api.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.PhotoComment;

@Repository
public interface PhotoCommentRepository extends JpaRepository<PhotoComment,Integer>{
	Optional<List<PhotoComment>> findAllByPhotoId(Integer photoId);
}
