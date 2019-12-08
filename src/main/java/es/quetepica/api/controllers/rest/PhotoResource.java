package es.quetepica.api.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.quetepica.api.controllers.bussines.PhotoController;

@RestController
@RequestMapping(PhotoResource.PHOTO)
public class PhotoResource {

		public static final String PHOTO = "photo";
		
		@Autowired
		private PhotoController photoController;
		
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
	    public String deletePhoto(Integer photoId) throws Exception {	       
			return this.photoController.deletePhoto(photoId);			
	    }	
		
}
