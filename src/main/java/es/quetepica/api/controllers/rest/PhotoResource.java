package es.quetepica.api.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.quetepica.api.controllers.bussines.PhotoController;
import es.quetepica.api.wrappers.PhotoWrapper;

@RestController
@RequestMapping(PhotoResource.PHOTO)
public class PhotoResource {

		public static final String PHOTO = "photo";
		public static final String LIST = "photolist";
		
		@Autowired
		private PhotoController photoController;
		
		@GetMapping
		public PhotoWrapper procurePhoto(Integer photoId) {
			return this.photoController.procurePhoto(photoId);
		}		
		
		@GetMapping(value = LIST)
		public List<PhotoWrapper> procureListPhotos(Integer phetProfileId) {
			return this.photoController.procureListPhotos(phetProfileId);
		}
		
		@PostMapping
	    public String uploadPhoto(@RequestParam(value = "file", required = true) MultipartFile file, Integer petProfileId
	    		,String title, String shortDesciprion) throws Exception {
	        if (file != null && !file.isEmpty()) {	           
	            return this.photoController.uploadPhoto(file,petProfileId,title,shortDesciprion);
	        } else {
	        	throw new Exception("Failed to load file.");
	        }
	    }	
		
		@DeleteMapping
	    public String deletePhoto(Integer photoId) {	       
			return this.photoController.deletePhoto(photoId);			
	    }	
		
}
