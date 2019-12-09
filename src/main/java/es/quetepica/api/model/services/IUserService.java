package es.quetepica.api.model.services;

import es.quetepica.api.wrappers.UserWrapper;

public interface IUserService {
	UserWrapper  getUserById(Integer userId);
	UserWrapper userLogin(String email, String password);
	UserWrapper createUser(UserWrapper userWrapper);		
	UserWrapper editUser(UserWrapper userWrapper);
}
