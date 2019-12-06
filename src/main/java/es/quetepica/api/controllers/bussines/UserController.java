package es.quetepica.api.controllers.bussines;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.quetepica.api.model.entities.User;
import es.quetepica.api.model.services.impl.UserServiceImpl;
import es.quetepica.api.wrappers.UserWrapper;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	public Optional<User> userLogin(String email, String password) {
		return this.userServiceImpl.userLogin(email,password);	
	};

	public UserWrapper createUser(UserWrapper userInputWrapper ) {
		return this.userServiceImpl.createUser(userInputWrapper);
	};

	public UserWrapper editUser(UserWrapper userInputWrapper ) {
		return this.userServiceImpl.editUser(userInputWrapper);
	};

}
