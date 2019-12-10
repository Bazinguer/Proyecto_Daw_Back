package es.quetepica.api.controllers.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.quetepica.api.model.services.impl.PetProfileServiceImpl;
import es.quetepica.api.wrappers.PetProfileWrapper;

@Controller
public class PetProfileController {
	
		@Autowired
		private PetProfileServiceImpl petProfileServiceImpl;
		
		public PetProfileWrapper creationPetProfile(PetProfileWrapper petProfileWrapper) {			
			return this.petProfileServiceImpl.createPetProfile(petProfileWrapper);			
		}
		
		public String deletePetProfile(Integer id,String nick) {			
			return this.petProfileServiceImpl.deletePetProfile(id,nick);			
		}
		
		public PetProfileWrapper editDesciptionPetProfile(PetProfileWrapper petProfileWrapper) {			
			return this.petProfileServiceImpl.editDesciptionPetProfile(petProfileWrapper);			
		}
			
		public List<PetProfileWrapper> listPetProfile(Integer userId){
			return this.petProfileServiceImpl.listPetProfile(userId);	
			
		}
		
		public PetProfileWrapper procurePetProfile(Integer petProfileId){
			return this.petProfileServiceImpl.procurePetProfile(petProfileId);
			
		}
}
