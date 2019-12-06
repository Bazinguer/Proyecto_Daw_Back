package es.quetepica.api.controllers.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.quetepica.api.controllers.bussines.UserController;
import es.quetepica.api.model.entities.User;
import es.quetepica.api.wrappers.UserWrapper;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {

	public static final String USERS = "/users";
	public static final String LOGIN = "/login";	

	@Autowired
	private UserController userController;	

	@GetMapping(value = LOGIN)
	public Optional<User> userLogin(String email, String password) {
		return this.userController.userLogin(email, password);
	}
	
	@PostMapping
	public UserWrapper createUser(UserWrapper userInputWrapper) {
		return this.userController.createUser(userInputWrapper);		
	}
	
	@PutMapping
	public UserWrapper editUser(UserWrapper userInputWrapper) {
		return this.userController.editUser(userInputWrapper);
	}


}
