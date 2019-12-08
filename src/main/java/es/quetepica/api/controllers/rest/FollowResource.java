package es.quetepica.api.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.quetepica.api.controllers.bussines.FollowController;
import es.quetepica.api.wrappers.FollowWrapper;


@RestController
@RequestMapping(FollowResource.FOLLOW)
public class FollowResource {
	
	public static final String FOLLOW = "/follow";
	public static final String LISTFOLLOW = "/listfollow";
	
	@Autowired
	private FollowController followController;
	
	@PostMapping
	public FollowWrapper createFollow(Integer idFollow,Integer idFollowed) {
		System.out.println("Entrandoooooooooooooo rest_controller");
		return this.followController.createFollow(idFollow,idFollowed);
	}	
	
	@GetMapping(value = LISTFOLLOW)
	public List<FollowWrapper> listFollows(Integer userId){
		return this.followController.listFollow(userId);			
	}		
	
	@DeleteMapping
	public String deleteFollow(Integer idFollow,Integer idFollowed) {
		return this.followController.deleteFollow(idFollow,idFollowed);
	}

}
