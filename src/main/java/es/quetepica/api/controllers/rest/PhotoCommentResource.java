package es.quetepica.api.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.quetepica.api.controllers.bussines.PhotoCommentController;
import es.quetepica.api.wrappers.PhotoCommentWrapper;

@RestController
@RequestMapping(PhotoCommentResource.COMMENT)
public class PhotoCommentResource {

		public static final String COMMENT = "/comments";
		public static final String COMMENTLIST = "/commentslist";
		
		@Autowired
		private PhotoCommentController photoCommentController; 
		
		@GetMapping(value = COMMENTLIST)
		public List<PhotoCommentWrapper> procureListComments(Integer photoId) {
			return this.photoCommentController.procureListComments(photoId);
		}
		
		@GetMapping
		public PhotoCommentWrapper procureComment(Integer commentId) {
			return this.photoCommentController.procureComment(commentId);
		}
		
		@PostMapping
		public Integer insertComment(@RequestBody PhotoCommentWrapper photoCommentWrapper) {
			 return this.photoCommentController.insertComment(photoCommentWrapper);
		}
		
		@DeleteMapping
	    public String deleteComment(Integer commentId) {	       
			return this.photoCommentController.deleteComment(commentId);			
	    }	
}
