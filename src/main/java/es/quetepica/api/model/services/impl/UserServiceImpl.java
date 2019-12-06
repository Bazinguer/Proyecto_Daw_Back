package es.quetepica.api.model.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.quetepica.api.configurations.exceptions.ConflictException;
import es.quetepica.api.configurations.exceptions.NotFoundException;
import es.quetepica.api.model.entities.User;
import es.quetepica.api.model.repositories.UserRepository;
import es.quetepica.api.model.services.IUserService;
import es.quetepica.api.wrappers.UserWrapper;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> userLogin(String email, String password) {
		//Se busca usuario por mail y pass, si NO existe se lanza excepcion sino se devuelve el usuario 				
		if (!this.userRepository.findByEmailAndPassword(email, password).isPresent()) {
			throw new NotFoundException("No existe ningún usuario con las credenciales introducidas.");
		} 		
		
		return this.userRepository.findByEmailAndPassword(email, password);		
	}

	@Override
	public UserWrapper createUser(UserWrapper userWrapper) {
		//Se busca usuario (), si NO existe se crea el nuevo usuario y se devuelve el mismo usuario		
		//Si no se lanza excepción de conflicto
		if (this.userRepository.findByIdAndEmail(userWrapper.getId(),userWrapper.getEmail()).isPresent()) {
			 throw new ConflictException("Ya existe un usuario con estos datos.");
		} 	

		User saved = new User(userWrapper.getUsername(),userWrapper.getEmail(),userWrapper.getPassword(),userWrapper.getBornDate());
		
		return new UserWrapper(this.userRepository.save(saved));		
	}

	@Override
	public UserWrapper editUser(UserWrapper userWrapper) {
		//Se busca usuario (), si existe se modifica el usuario existente y se devuelve el mismo usuario actualizado
		//Si no existe se lanza una excepción notFound
		if (!this.userRepository.findByIdAndEmail(userWrapper.getId(),userWrapper.getEmail()).isPresent()) {
		 	 throw new NotFoundException("No existe un usuario con estos datos.");
		} 	
		User saved = new User(userWrapper.getUsername(),userWrapper.getEmail(),userWrapper.getPassword(),userWrapper.getBornDate());
		
		return new UserWrapper(this.userRepository.save(saved));		
	}

}
