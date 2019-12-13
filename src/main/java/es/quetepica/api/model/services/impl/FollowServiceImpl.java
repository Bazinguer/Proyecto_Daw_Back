package es.quetepica.api.model.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.quetepica.api.configurations.exceptions.ConflictException;
import es.quetepica.api.model.entities.Follow;
import es.quetepica.api.model.entities.PetProfile;
import es.quetepica.api.model.repositories.FollowRepository;
import es.quetepica.api.model.repositories.PetProfileRepository;
import es.quetepica.api.model.services.IFollowService;
import es.quetepica.api.wrappers.FollowWrapper;

@Service
public class FollowServiceImpl implements IFollowService {

	@Autowired
	private FollowRepository followRepository;

	@Autowired 
	private PetProfileRepository petProfileRepository;

	@Override
	public FollowWrapper createFollow(Integer idFollow,Integer idFollowed) {	

		if (this.followRepository.findByPetprofileIdAndFollowed(idFollow, idFollowed).isPresent()) {			
			throw new ConflictException("Ya se está siguiendo.");			
		}	
		
		Optional<PetProfile> profile = this.petProfileRepository.findById(idFollow);	

		if (profile.isPresent()) {
			Follow follow = new Follow(profile.get(), idFollowed);		
			return new FollowWrapper(this.followRepository.save(follow));
		} else {
			throw new ConflictException("Error al crear el registro.");	
		}

	}

	@Override
	public List<FollowWrapper> listFollow(Integer petProfileId) {
		
		Optional<List<Follow>> listFollow = this.followRepository.findAllByPetprofileId(petProfileId);

		if (listFollow.isPresent()) {

			List<FollowWrapper> listFollowWrapper = new ArrayList<FollowWrapper>();

			for(Follow petfollow: listFollow.get()) {
				listFollowWrapper.add(new FollowWrapper(petfollow));
			}
			return listFollowWrapper;			

		}else {
			List<FollowWrapper> vacia = new ArrayList<FollowWrapper>();
			return vacia;
		}
	}

	@Override
	public String deleteFollow(Integer idFollow, Integer idFollowed) {

		Optional<Follow> follow = this.followRepository.findByPetprofileIdAndFollowed(idFollow, idFollowed);

		if (follow.isPresent()) {	
			this.followRepository.delete(follow.get());			
			return "Se ha eliminado correctamente";
		}else {
			return "No existe dicho usuario.";
		}

	}

	@Override
	public List<FollowWrapper> listFollowed(Integer petProfileId) {
		Optional<List<Follow>> listFollowed = this.followRepository.findAllByFollowed(petProfileId);

		if (listFollowed.isPresent()) {

			List<FollowWrapper> listFollowedWrapper = new ArrayList<FollowWrapper>();

			for(Follow petfollow: listFollowed.get()) {
				listFollowedWrapper.add(new FollowWrapper(petfollow));
			}
			return listFollowedWrapper;			

		}else {
			List<FollowWrapper> vacia = new ArrayList<FollowWrapper>();
			return vacia;
		}
	}

}
