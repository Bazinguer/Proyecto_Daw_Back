package es.quetepica.api.controllers.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.quetepica.api.model.services.impl.FollowServiceImpl;
import es.quetepica.api.wrappers.FollowWrapper;


@Controller
public class FollowController {
		
		@Autowired
		private FollowServiceImpl followServiceImpl;
		
		public FollowWrapper createFollow(Integer idFollow,Integer idFollowed) {
			return this.followServiceImpl.createFollow(idFollow,idFollowed);
		}
		
		public List<FollowWrapper> listFollow(Integer userId){
			return this.followServiceImpl.listFollow(userId);
		}	
		
		public List<FollowWrapper> listFollowed(Integer petProfileId){
			return this.followServiceImpl.listFollowed(petProfileId);
		}

		public String deleteFollow(Integer idFollow,Integer idFollowed) {	
			return this.followServiceImpl.deleteFollow(idFollow, idFollowed);			
		}		
	

}
