package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.User;


public interface DataService {
	public List<User> findAll();
	public User save(User u);
	public Optional<User> findById(int id);
	public void deleteUserById(@PathVariable int id);
	public User update(User user, int id);
}
