package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepo repo;

	@GetMapping
	public User findUsers(@RequestParam String name) {
		return repo.findUserByName(name);
	}

	@PostMapping
	public User save(@RequestBody User user) {
		System.out.println(user);
		return repo.save(user);
	}

	@GetMapping("/{id}")
	public Optional<User> findUserById(@PathVariable int id) {
		return repo.findById(id);
	}
	
	@GetMapping("/test")
	public Iterable<User> test() {
		repo.deleteById(1000);
		return repo.findAll();
	}
}
