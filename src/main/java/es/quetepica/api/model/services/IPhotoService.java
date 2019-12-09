package es.quetepica.api.model.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import es.quetepica.api.wrappers.PhotoWrapper;

public interface IPhotoService {
	PhotoWrapper procurePhoto(Integer photoId);
	List<PhotoWrapper> procureListPhotos(Integer petProfileId);
	String uploadPhoto(MultipartFile file,Integer petProfileId,String title, String shortDesciprion);
	String deletePhoto(Integer photoId);
}
