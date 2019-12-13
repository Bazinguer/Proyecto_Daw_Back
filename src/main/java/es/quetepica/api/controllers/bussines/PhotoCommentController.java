package es.quetepica.api.controllers.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.quetepica.api.model.services.impl.PhotoCommentServiceImpl;
import es.quetepica.api.wrappers.PhotoCommentWrapper;

@Controller
public class PhotoCommentController {

	@Autowired
	private PhotoCommentServiceImpl photoCommentServiceImpl;

	public List<PhotoCommentWrapper> procureListComments(Integer photoId) {
		return this.photoCommentServiceImpl.procureListComments(photoId);
	}

	public PhotoCommentWrapper procureComment(Integer commentId) {
		return this.photoCommentServiceImpl.procureComment(commentId);
	}

	public String deleteComment(Integer commentId) {	       
		return this.photoCommentServiceImpl.deleteComment(commentId);			
	}	
	
	public Integer insertComment(PhotoCommentWrapper photoCommentWrapper) {
		return this.photoCommentServiceImpl.insertComment(photoCommentWrapper);
	}

}
