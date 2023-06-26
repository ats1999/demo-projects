package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	UserRepository userRepository;
	
	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	User saveUser(User user) {
		return userRepository.save(user);
	}
	
	Optional<User> getUser(long id) {
		return userRepository.findById(id);
	}
	
	List<Subject> findSubjectsById(long id) {
		return userRepository.findSubjectsById(id);
	}
}
