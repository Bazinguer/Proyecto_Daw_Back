package es.quetepica.api.model.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.quetepica.api.configurations.exceptions.NotFoundException;
import es.quetepica.api.model.entities.PhotoComment;
import es.quetepica.api.model.repositories.PhotoCommentRepository;
import es.quetepica.api.model.services.IPhotoCommentService;
import es.quetepica.api.wrappers.PhotoCommentWrapper;

@Service
public class PhotoCommentServiceImpl implements IPhotoCommentService {

	@Autowired
	private PhotoCommentRepository photoCommentRepository;

	@Override
	public List<PhotoCommentWrapper> procureListComments(Integer photoId) {

		Optional<List<PhotoComment>> listCommentsPhoto = this.photoCommentRepository.findAllByPhotoId(photoId);	

		if (listCommentsPhoto.isPresent()) {			

			List<PhotoCommentWrapper> listComments = new ArrayList<PhotoCommentWrapper>();

			for(PhotoComment comment: listCommentsPhoto.get()) {
				listComments.add(new PhotoCommentWrapper(comment));
			}
			return listComments;		

		}else {
			throw new NotFoundException("No se encuentran comentarios asociados a esta foto. Revisa la petición");
		}
	}

	@Override
	public PhotoCommentWrapper procureComment(Integer commentId) {		
		Optional<PhotoComment> findComment = this.photoCommentRepository.findById(commentId);		
		if (findComment.isPresent()) {			
			return new PhotoCommentWrapper(this.photoCommentRepository.findById(commentId).get());
		} else {
			throw new NotFoundException("No se enontró ningun comentario con ese ID");	
		}

	}

	@Override
	public String deleteComment(Integer commentId) {

		Optional<PhotoComment> findPhoto = this.photoCommentRepository.findById(commentId);

		if (findPhoto.isPresent()) {	
			this.photoCommentRepository.delete(findPhoto.get());		
			return "Se ha eliminado correctamente";
		}else {
			throw new NotFoundException("No se ha encontrado ningún registro con los datos facilitados.");
		}
	}

}
