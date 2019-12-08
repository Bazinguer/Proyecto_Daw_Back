package es.quetepica.api.model.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.Follow;
import es.quetepica.api.wrappers.FollowWrapper;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer>{

	Optional<FollowWrapper> findByPetprofileIdAndFollowed(Integer followId, Integer followedId);	
	
	Optional<List<Follow>> findAllByPetprofileId(Integer id);

	Optional<Follow> findByPetprofileAndFollowed(Integer followId, Integer followedId);
}
