package es.quetepica.api.model.services;

import es.quetepica.api.wrappers.PetProfileWrapper;

public interface IPetProfileService {
		
	public PetProfileWrapper createPetProfile(PetProfileWrapper petProfileWrapper);		
	public String deletePetProfile(Integer id,String nick);
	public PetProfileWrapper editDesciptionPetProfile(PetProfileWrapper petProfileWrapper);

}
