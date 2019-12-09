package es.quetepica.api.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.quetepica.api.controllers.bussines.UserController;
import es.quetepica.api.wrappers.UserWrapper;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {

	public static final String USERS = "/users";
	public static final String LOGIN = "/login";	

	@Autowired
	private UserController userController;	

	@GetMapping(value = LOGIN)
	public UserWrapper userLogin(String email, String password) {
		return this.userController.userLogin(email, password);
	}
	
	@GetMapping
	public UserWrapper getUserById(Integer userId) {
		return this.userController.getUserById(userId);
	}
	
	@PostMapping
	public UserWrapper createUser(@RequestBody UserWrapper userInputWrapper) {
		return this.userController.createUser(userInputWrapper);		
	}
	
	@PutMapping
	public UserWrapper editUser(@RequestBody UserWrapper userInputWrapper) {
		return this.userController.editUser(userInputWrapper);
	}

}
