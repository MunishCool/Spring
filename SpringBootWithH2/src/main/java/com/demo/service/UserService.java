package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll();
		return users;
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void saveOrUpdate(User user) {

		userRepository.save(user);

	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
}
