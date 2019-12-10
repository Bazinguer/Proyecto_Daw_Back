package es.quetepica.api.model.services.impl;

import java.util.ArrayList;
import java.util.List;
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

		Optional<PetProfile> petProfile = this.petProfileRepository.findByIdAndNick(petProfileWrapper.getId(),petProfileWrapper.getNick());

		if (petProfile.isPresent()) {			
			throw new ConflictException("Se ha encontrado un perfil de mascota con los datos facilitados.");			
		}
		else {
			PetProfile petProfileInsert = new PetProfile(petProfileWrapper.getUser(),petProfileWrapper.getNick(),petProfileWrapper.getSexo(),petProfileWrapper.getRaza(),petProfileWrapper.getImgProfile(),petProfileWrapper.getDescription(),petProfileWrapper.getPetBornDate());
			return new PetProfileWrapper(this.petProfileRepository.save(petProfileInsert));
		}

	}

	@Override
	public String deletePetProfile(Integer id,String nick) {
	
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
	
		Optional<PetProfile> petProfileEdit = this.petProfileRepository.findById(petProfileWrapper.getId());

		if (petProfileEdit.isPresent()) {
			petProfileEdit.get().setDescription(petProfileWrapper.getDescription());
			
			return new PetProfileWrapper(this.petProfileRepository.save(petProfileEdit.get()));
			
		}else {
			throw new BadRequestException("No se ha podido actualizar la descripción del perfil.");
		}

	}

	@Override
	public List<PetProfileWrapper> listPetProfile(Integer userId) {

		Optional<List<PetProfile>> listPetProfileUser = this.petProfileRepository.findAllByUserId(userId);

		if (listPetProfileUser.isPresent()) {
			
			List<PetProfileWrapper> listPetProfileWrapper = new ArrayList<PetProfileWrapper>();
			
				for(PetProfile petProfile: listPetProfileUser.get()) {
					listPetProfileWrapper.add(new PetProfileWrapper(petProfile));
				}
				return listPetProfileWrapper;			

		}else {
			throw new NotFoundException("No se encuentran perfiles. Revisa la petición");
		}
	}

	@Override
	public PetProfileWrapper procurePetProfile(Integer petProfileId) {
		Optional<PetProfile> petProfile = this.petProfileRepository.findById(petProfileId);
		if (petProfile.isPresent()) {			
				return new PetProfileWrapper(petProfile.get());			

		}else {
			throw new NotFoundException("No se encuentran perfiles. Revisa la petición");
		}
	}

}
