package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	<S extends User> S save(S user);
	Optional<User> findById(Long id);
	List<Subject> findSubjectsById(Long id);
}
