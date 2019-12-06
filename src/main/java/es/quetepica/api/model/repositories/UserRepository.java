package es.quetepica.api.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.User;
import es.quetepica.api.wrappers.UserWrapper;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByEmailAndPassword(String email, String password);
	Optional<UserWrapper> findByIdAndEmail(int id,String email);
}
