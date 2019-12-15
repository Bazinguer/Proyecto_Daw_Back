package es.quetepica.api.model.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.quetepica.api.configurations.exceptions.FileException;
import es.quetepica.api.configurations.exceptions.NotFoundException;
import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.entities.Photo;
import es.quetepica.api.model.repositories.PetProfileRepository;
import es.quetepica.api.model.repositories.PhotoRepository;
import es.quetepica.api.model.services.IPhotoService;
import es.quetepica.api.wrappers.PhotoWrapper;

@Service
public class PhotoServiceImpl implements IPhotoService {

	
	public String uploadDir = "S:\\Xampp\\htdocs\\img\\";
	
	@Autowired
	private PhotoRepository photoRepository;

	@Autowired 
	private PetProfileRepository petProfileRepository;

	@Override
	public String uploadPhoto(MultipartFile file,Integer petProfileId,String title, String shortDesciprion) {		
		
		try {		
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadDir + file.getOriginalFilename());
			Files.write(path, bytes);
			
			Optional<PetProfile> profile = this.petProfileRepository.findById(petProfileId);

			if (profile.isPresent()) {
				Photo uploadPhoto = new Photo(profile.get(),"http://localhost/img/"+file.getOriginalFilename(),title, shortDesciprion);				
				this.photoRepository.save(uploadPhoto);
				return "Foto subida correctamente";			    
			}else {
				return "Problemas al subir la foto correctamente";	
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new FileException("Problema al cargar el archivo: " + file.getOriginalFilename() + file.getName()
			+ ". Intentelo de nuevo.");
		}

	}

	@Override
	public String deletePhoto(Integer photoId){		

		Optional<Photo> findPhoto = this.photoRepository.findById(photoId);

		if (findPhoto.isPresent()) {	
			
			String s= findPhoto.get().getUrl();			
			String n = s.substring(21,s.length());		

			File imagen = new File(uploadDir+n);
			
			FileInputStream readImage;
			try {
				readImage = new FileInputStream(imagen);
				readImage.close();
				imagen.delete();

				this.photoRepository.delete(findPhoto.get());		
				return "Se ha eliminado correctamente";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new FileException("Problemas al intentar eliminar la foto");
			}	

		}else {
			throw new NotFoundException("No se ha encontrado ningún registro con los datos facilitados.");
		}

	}

	@Override
	public PhotoWrapper procurePhoto(Integer photoId) {		
		
		Optional<Photo> findPhoto = this.photoRepository.findById(photoId);
		
		if (findPhoto.isPresent()) {			
			return new PhotoWrapper(this.photoRepository.findById(photoId).get());
		} else {
			throw new NotFoundException("No se enontró ninguna foto con ese ID");
		}
		
	}

	@Override
	public List<PhotoWrapper> procureListPhotos(Integer petProfileId) {
		
		 Optional<List<Photo>> listProfilePhotos = this.photoRepository.findAllByPetprofileId(petProfileId);	
		 
		 if (listProfilePhotos.isPresent()) {			
			 
			List<PhotoWrapper> listPhotos = new ArrayList<PhotoWrapper>();
				
				for(Photo photo: listProfilePhotos.get()) {
					listPhotos.add(new PhotoWrapper(photo));
				}
				return listPhotos;		
				
			}else {
				throw new NotFoundException("No se encuentran fotos asociadas al perfil. Revisa la petición");
			}
	}

}
