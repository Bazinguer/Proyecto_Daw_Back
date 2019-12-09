package es.quetepica.api.model.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer>{
	
	Optional<Follow> findByPetprofileIdAndFollowed(Integer followId, Integer followedId);	
	
	Optional<List<Follow>> findAllByPetprofileId(Integer userId);

	Optional<Follow> findByPetprofileAndFollowed(Integer followId, Integer followedId);
}
