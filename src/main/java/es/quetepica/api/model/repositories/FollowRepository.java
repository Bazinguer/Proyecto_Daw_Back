package es.quetepica.api.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.quetepica.api.model.entities.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long>{

}
