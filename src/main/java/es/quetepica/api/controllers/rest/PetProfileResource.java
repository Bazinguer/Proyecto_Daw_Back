package es.quetepica.api.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.quetepica.api.controllers.bussines.PetProfileController;
import es.quetepica.api.wrappers.PetProfileWrapper;

@RestController
@RequestMapping(name = PetProfileResource.PETPROFILE)
public class PetProfileResource {

	@Autowired
	private PetProfileController petProfileController;

	public static final String PETPROFILE = "/petprofile";
	public static final String USER = "/user";
	public static final String PET = "/pet";

	@PostMapping(name = USER)
	public PetProfileWrapper creationPetProfile(@RequestBody PetProfileWrapper petProfileInputWrapper) {
		return this.petProfileController.creationPetProfile(petProfileInputWrapper);
	}	

	@DeleteMapping(name = USER)
	public String deletePetProfile(Integer id,String nick) {
		return this.petProfileController.deletePetProfile(id,nick);
	}

	@PutMapping(name = PET)
	public PetProfileWrapper editDescripcion(@RequestBody PetProfileWrapper petProfileInputWrapper) {
		return this.petProfileController.editDesciptionPetProfile(petProfileInputWrapper);
	}

}
