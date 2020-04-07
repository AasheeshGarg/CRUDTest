package com.example.CRUDExample.service;

import com.example.CRUDExample.model.User;
import com.example.CRUDExample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	private Logger logger = Logger.getLogger(UserService.class.getName());

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(Long userId) {
		return userRepository.findByUserId(userId);
	}

	public void addUser(User user) {
		List<User> users = this.getAllUsers();

		if(users.isEmpty())
			userRepository.save(user);
		for(User u : users) {
			if(u.getUsername().equals(user.getUsername())) {
				logger.info("User already Registered !!!");
				throw new IllegalArgumentException("User already registered.");
			}

			userRepository.save(user);
		}
	}

	public void updateUser(Long userId, User user) {
		user.setUserId(userId);
		userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
