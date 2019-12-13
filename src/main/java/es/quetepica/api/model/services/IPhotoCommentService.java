package es.quetepica.api.model.services;

import java.util.List;

import es.quetepica.api.wrappers.PhotoCommentWrapper;

public interface IPhotoCommentService {		
	Integer insertComment(PhotoCommentWrapper photoCommentWrapper);
	List<PhotoCommentWrapper> procureListComments(Integer photoId);
	PhotoCommentWrapper procureComment(Integer commentId);
	String deleteComment(Integer commentId);
}
