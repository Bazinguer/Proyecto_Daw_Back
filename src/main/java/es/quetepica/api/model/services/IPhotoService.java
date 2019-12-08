package es.quetepica.api.model.services;

import org.springframework.web.multipart.MultipartFile;

public interface IPhotoService {
	
	String uploadPhoto(MultipartFile file,Integer petProfileId,String title, String shortDesciprion);
	String deletePhoto(Integer photoId);
}
