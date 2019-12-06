package es.quetepica.api.model.services;

import java.util.Optional;

import es.quetepica.api.model.entities.User;
import es.quetepica.api.wrappers.UserWrapper;

public interface IUserService {

	public Optional<User> userLogin(String email, String password);
	public UserWrapper createUser(UserWrapper userWrapper);		
	public UserWrapper editUser(UserWrapper userWrapper);
}
