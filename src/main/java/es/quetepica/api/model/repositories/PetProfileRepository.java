package es.quetepica.api.model.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.PetProfile;

@Repository
public interface PetProfileRepository extends JpaRepository<PetProfile, Integer>{	
	Optional<PetProfile> findByIdAndNick(Integer petProfileId,String nick);
	Optional<PetProfile> findByNick(String nick);
	Optional<List<PetProfile>> findAllByUserId(Integer userId);
	Optional<List<PetProfile>> findAllByRazaContainsAndSexoContains(String raza,String sexo);
	
	@Query("SELECT * FROM pet_profiles WHERE raza LIKE '%:raza%' AND sexo LIKE '%:sexo%' AND Year(petBornDate))")
	Optional<List<PetProfile>> findAllByRazaContainsAndSexoContainsAndPetBornDate(@Param("raza") String raza,@Param("sexo") String sexo,@Param("petBornDate")@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)  Date petBornDate);
}
