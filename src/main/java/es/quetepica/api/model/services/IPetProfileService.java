package es.quetepica.api.model.services;

import java.util.List;

import es.quetepica.api.wrappers.PetProfileWrapper;

public interface IPetProfileService {
		
	PetProfileWrapper createPetProfile(PetProfileWrapper petProfileWrapper);		
	String deletePetProfile(Integer id,String nick);
	PetProfileWrapper editDesciptionPetProfile(PetProfileWrapper petProfileWrapper);
	List<PetProfileWrapper> listPetProfile(Integer userId);
	PetProfileWrapper procurePetProfile(Integer petProfileId);
	List<PetProfileWrapper> listSerchProfiles(String raza, String sexo, Integer petBorndDate);
	PetProfileWrapper procurePetProfileByNick(String petNick);

}
