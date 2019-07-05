package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.DataRepository;

@RestController
@RequestMapping("/users")
public class DataController {

	@Autowired
	DataRepository repository;

	@GetMapping(value = "/getUsers")
	public List<User> getAllList() {
		Iterable<User> findAll = repository.findAll();
		List<User> list= new ArrayList<User>();
		for (User user : findAll) {
			list.add(user);
			}
		return list;
	}

	// insert new item into databas
	@PostMapping("/insertUsers")
	public User addNewUser(@RequestBody User user) {

		return repository.save(user);
	}
	
	@GetMapping(value= "/getUserById/{id}")
    public User getUserById(@PathVariable int id) throws Exception {
        Optional<User> emp =  repository.findById(id);
        if(!emp.isPresent())
            throw new Exception("Could not find employee	 with id- " + id);
         return emp.get();
    }
	
	
	  @PutMapping("/updateUserById/{id}")
	  public ResponseEntity<String> updateUser(@RequestBody User currentUser)
	    {
	        Optional<User> user = repository.findById(currentUser.getId());
	        if (user==null) {
	            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	        }
	        repository.update(currentUser, currentUser.getId());
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }
	 
	
	@DeleteMapping(value= "/deleteUserById/{id}")
	public void deleteUserById(@PathVariable int id) {
		repository.deleteById(id);
	}
}
