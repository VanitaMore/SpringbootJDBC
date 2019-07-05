package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.DataRepository;

@Service(value = "dataService")
public class DataServiceImpl implements DataService {

	@Autowired DataRepository dataRepo;

	@Override
	public List<User> findAll() {
		
		return (List<User>) dataRepo.findAll();
	}

	@Override
	public User save(User u) {
		return dataRepo.save(u);
	}

	@Override
	public Optional<User> findById(int id) {
		return dataRepo.findById(id);
	}

	@Override
	public void deleteUserById(int id) {
	}

	@Override
	public User update(User user, int id) {
		Optional<User> findById = dataRepo.findById(id);
		List<User> userList= new ArrayList<User>();
	   return dataRepo.save(user);
	}
	
	
}
