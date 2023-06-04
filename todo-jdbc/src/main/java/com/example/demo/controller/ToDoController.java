package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ToDoModel;
import com.example.demo.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {
	@Autowired
	ToDoService toDoService;
	
	@PostMapping
	public String createToDo(@RequestBody String name) throws InterruptedException {
		Thread.sleep(100);
		return toDoService.createToDo(name);
	}

	@GetMapping
	public List<ToDoModel> getToDos() {
		return toDoService.getToDos();
	}

	@GetMapping("/{todoId}")
	public ToDoModel getToDo(@PathVariable String todoId) {
		return toDoService.getToDo(todoId);
	}

	@DeleteMapping("/{todoId}")
	public String deleteToDo(@PathVariable String todoId) {
		return toDoService.deleteToDo(todoId);
	}

	@PutMapping("/status/{todoId}")
	public String changesStatus(@PathVariable String todoId, @RequestBody String status) {
		return toDoService.changesStatus(todoId, status);
	}
}
