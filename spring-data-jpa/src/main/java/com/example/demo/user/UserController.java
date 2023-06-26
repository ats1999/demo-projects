package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	UserService userService;
	
	UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/{id}/subjects")
	public List<Subject> getSubjectsById(@PathVariable long id){
		return userService.findSubjectsById(id);
	}
	
}
