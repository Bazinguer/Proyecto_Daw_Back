package es.quetepica.api.controllers.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.quetepica.api.controllers.bussines.PetProfileController;
import es.quetepica.api.wrappers.PetProfileWrapper;

@RestController
@RequestMapping(PetProfileResource.PETPROFILE)
public class PetProfileResource {
	
	public static final String PETPROFILE = "/petprofile";
	public static final String LISTPROFILE = "/listprofile";	

	@Autowired
	private PetProfileController petProfileController;	
	
	@PostMapping
	public PetProfileWrapper creationPetProfile(@RequestBody PetProfileWrapper petProfileInputWrapper) {
		return this.petProfileController.creationPetProfile(petProfileInputWrapper);
	}	
	
	@GetMapping(value = LISTPROFILE)
	public List<PetProfileWrapper> listPetProfileUser(Integer userId){
		return this.petProfileController.listPetProfile(userId);			
	}		
	
	@DeleteMapping
	public String deletePetProfile(Integer id,String nick) {
		return this.petProfileController.deletePetProfile(id,nick);
	}

	@PutMapping
	public PetProfileWrapper editDescripcion(@RequestBody PetProfileWrapper petProfileInputWrapper) {
		return this.petProfileController.editDesciptionPetProfile(petProfileInputWrapper);
	}
	
	

}
