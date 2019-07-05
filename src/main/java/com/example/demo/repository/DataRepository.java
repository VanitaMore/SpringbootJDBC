package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.User;

@Repository
public interface DataRepository extends CrudRepository<User, Integer>{

	Optional<User> findById(int id);

	void update(User currentUser, int id);

	

}
