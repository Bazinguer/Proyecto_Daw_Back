package es.quetepica.api.controllers.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import es.quetepica.api.model.services.impl.PhotoServiceImpl;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoServiceImpl photoServiceImpl;
	
	public String uploadPhoto(MultipartFile file, Integer petProfileId,String title, String shortDesciprion) {
		return this.photoServiceImpl.uploadPhoto(file,petProfileId,title,shortDesciprion);
	}
	
	public String deletePhoto(Integer photoId) {
		return this.photoServiceImpl.deletePhoto(photoId);
	}
			
	}
