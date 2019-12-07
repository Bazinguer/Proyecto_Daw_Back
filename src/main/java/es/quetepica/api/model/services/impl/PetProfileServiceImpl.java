package es.quetepica.api.model.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.quetepica.api.configurations.exceptions.BadRequestException;
import es.quetepica.api.configurations.exceptions.ConflictException;
import es.quetepica.api.configurations.exceptions.NotFoundException;
import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.repositories.PetProfileRepository;
import es.quetepica.api.model.services.IPetProfileService;
import es.quetepica.api.wrappers.PetProfileWrapper;


@Service
public class PetProfileServiceImpl implements IPetProfileService {

	@Autowired
	private PetProfileRepository petProfileRepository;

	@Override
	public PetProfileWrapper createPetProfile(PetProfileWrapper petProfileWrapper) {
		//Se busca por nick el perfil de la mascota, si no existe se crea
		//Si existe lanzamos una excepción de conflicto	

		if (this.petProfileRepository.findByIdAndNick(petProfileWrapper.getId(),petProfileWrapper.getNick()).isPresent()) {			
			throw new ConflictException("Se ha encontrado un perfil de mascota con los datos facilitados.");			
		}

		PetProfile petProfile = new PetProfile(petProfileWrapper.getUser(),petProfileWrapper.getNick(),petProfileWrapper.getSexo(),petProfileWrapper.getRaza(),petProfileWrapper.getImgProfile(),petProfileWrapper.getDescription(),petProfileWrapper.getPetBornDate());

		try {
			return new PetProfileWrapper(this.petProfileRepository.save(petProfile));
		} catch (Exception e) {
			throw new BadRequestException("Problema al insertar en la base de datos.Compruebe estructura JSON, o el nick ya existe");
		}


	}

	@Override
	public String deletePetProfile(Integer id,String nick) {
		//Se busca perfilde la mascota, si existe se elimina
		//Si no existe se lanza una excepción notFound	
		Optional<PetProfile> petProfileEdit = this.petProfileRepository.findById(id);

		if (petProfileEdit.isPresent()) {
			String nickDelete = petProfileEdit.get().getNick();
			this.petProfileRepository.delete(petProfileEdit.get());			
			return "Se ha eliminado el perfil " + "@" + nickDelete;
		}else {
			throw new NotFoundException("No se ha encontrado ningún perfil de mascota con los datos facilitados.");
		}

	}

	@Override
	public PetProfileWrapper editDesciptionPetProfile(PetProfileWrapper petProfileWrapper) {
		//Se busca perfilde la mascota, si existe se modifica y se devuelve
		//Si no existe se lanza una excepción badRequest	
		Optional<PetProfile> petProfileEdit = this.petProfileRepository.findById(petProfileWrapper.getId());

		if (petProfileEdit.isPresent()) {
			petProfileEdit.get().setDescription(petProfileWrapper.getDescription());

			try {
				return new PetProfileWrapper(this.petProfileRepository.save(petProfileEdit.get()));
			} catch (Exception e) {
				throw new BadRequestException("dfsgfsdgf");
			}

		}else {
			throw new BadRequestException("No se ha podido actualizar la descripción del perfil.");
		}

	}

}
