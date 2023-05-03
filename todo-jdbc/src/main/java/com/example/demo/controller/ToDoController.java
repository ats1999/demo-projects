package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.ToDoModel;

@Controller
@RequestMapping("/todos")
public class ToDoController {

	@PostMapping
	public ToDoModel createToDo(@RequestBody ToDoModel todo) {
		return todo;
	}

	@GetMapping
	public ToDoModel[] getToDos() {
		return null;
	}

	@GetMapping("/{todoId}")
	public ToDoModel getToDo(@PathVariable String todoId) {
		return null;
	}

	@DeleteMapping("/{todoId}")
	public String deleteToDo(@PathVariable String todoId) {
		return todoId;
	}

	@PutMapping("/status/{todoId}")
	public String changesStatus(@PathVariable String todoId, @RequestBody String body) {
		return null;
	}
}
