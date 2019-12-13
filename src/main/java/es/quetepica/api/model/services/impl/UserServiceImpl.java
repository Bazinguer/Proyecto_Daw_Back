package es.quetepica.api.model.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.quetepica.api.configurations.exceptions.BadRequestException;
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
	public UserWrapper userLogin(String email, String password) {

		Optional<User> user = this.userRepository.findByEmailAndPassword(email, password);

		if (user.isPresent()) {			
			return new UserWrapper(user.get());			
		} else {
			throw new NotFoundException("No existe ningún usuario con las credenciales introducidas.");
		}		

	}

	@Override
	public UserWrapper createUser(UserWrapper userWrapper) {
		
		Optional<User> user = this.userRepository.findByEmailAndPassword(userWrapper.getEmail(),userWrapper.getPassword());	

		if (user.isPresent()) {
			throw new ConflictException("Ya existe un usuario con estos datos.");
		} else {
			User saved = new User(userWrapper.getUsername(),userWrapper.getEmail(),userWrapper.getPassword(),userWrapper.getBornDate());
			return new UserWrapper(this.userRepository.save(saved));	
		}

	}

	@Override
	public UserWrapper editUser(UserWrapper userWrapper) {
		//Se busca usuario (), si existe se modifica el usuario existente y se devuelve el mismo usuario actualizado
		//Si no existe se lanza una excepción badRequest		
		Optional<User> userEdit = this.userRepository.findById(userWrapper.getId());

		if (userEdit.isPresent()) {
			userEdit.get().setUsername(userWrapper.getUsername());
			userEdit.get().setPassword(userWrapper.getPassword());		
			System.out.println(userEdit.toString());
			
			return new UserWrapper(this.userRepository.save(userEdit.get()));

		}else {
			throw new BadRequestException("No se han podido actualizar los datos del usuario.");
		}

	}

	@Override
	public UserWrapper getUserById(Integer userId) {

		Optional<User> user = this.userRepository.findById(userId);

		if (user.isPresent()) {						
			return new UserWrapper(this.userRepository.save(user.get()));

		}else {
			throw new NotFoundException("No se ha encontrado usuario con ese ID.");
		}
	}

}
