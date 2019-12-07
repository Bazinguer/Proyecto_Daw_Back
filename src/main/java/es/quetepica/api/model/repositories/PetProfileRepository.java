package es.quetepica.api.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.wrappers.PetProfileWrapper;

@Repository
public interface PetProfileRepository extends JpaRepository<PetProfile, Integer>{	
	Optional<PetProfileWrapper> findByIdAndNick(Integer petProfileId,String nick);
}
