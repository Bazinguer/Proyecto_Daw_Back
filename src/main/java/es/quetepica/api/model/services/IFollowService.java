package es.quetepica.api.model.services;

import java.util.List;

import es.quetepica.api.wrappers.FollowWrapper;

public interface IFollowService {	
	FollowWrapper createFollow(Integer idFollow,Integer idFollowed);
	List<FollowWrapper> listFollow(Integer userId);
	String deleteFollow(Integer idFollow,Integer idFollowed);		
}
