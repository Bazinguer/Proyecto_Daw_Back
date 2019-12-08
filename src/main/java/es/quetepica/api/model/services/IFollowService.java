package es.quetepica.api.model.services;

import java.util.List;

import es.quetepica.api.wrappers.FollowWrapper;

public interface IFollowService {	
	public FollowWrapper createFollow(Integer idFollow,Integer idFollowed);
	public List<FollowWrapper> listFollow(Integer userId);
	public String deleteFollow(Integer idFollow,Integer idFollowed);		
}
