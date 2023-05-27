package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.ToDoModel;
import com.example.demo.repository.ToDoRepo;

@Service
public class ToDoServiceImpl implements ToDoService {
	@Autowired
	ToDoRepo toDoRepo;
	
	@Override
	public String createToDo(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name must be provided!");
		}
		
		return toDoRepo.createToDo(name);
	}

	@Override
	public List<ToDoModel> getToDos() {
		return toDoRepo.getToDos();
	}

	@Override
	public ToDoModel getToDo(String todoId) {
		return toDoRepo.getToDo(todoId);
	}

	@Override
	public String deleteToDo(String todoId) {
		return toDoRepo.deleteToDo(todoId);
	}

	@Override
	public String changesStatus(String todoId, String status) {
		return toDoRepo.changesStatus(todoId, status);
	}

}
