package com.todo.inmemory.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.inmemory.exceptions.UnprocessableEntityHttpException;
import com.todo.inmemory.models.ToDo;
import com.todo.inmemory.services.ToDoService;
import com.todo.inmemory.services.ToDoServiceImpl;

@RestController
@RequestMapping("/todo")
public class ToDoController {
	private ToDoService service = new ToDoServiceImpl();
	
	@GetMapping("/{todoId}")
	public ResponseEntity<Object> getToDo(@PathVariable long todoId) {
		ToDo todo = service.getToDo(todoId);
		
		ResponseEntity<Object> response;
		
		if(todo != null) {
			response = new ResponseEntity<>(todo,HttpStatus.OK);
		}else {
			response = new ResponseEntity<Object>("ToDo not found:)",HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@GetMapping
	public ArrayList<ToDo> getToDos() {
		return service.getToDos();
	}
	
	@PostMapping
	public ResponseEntity<String> createToDo(@RequestBody ToDo todo) {
		service.createToDo(todo);
		ResponseEntity<String> responseEntity= new ResponseEntity<>("ToDo Created", HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping
	public ResponseEntity<String> updateToDo(@RequestBody ToDo todo) {
		boolean updatedToDo = service.updateToDo(todo);
		
		ResponseEntity<String> response;
		
		if(updatedToDo) {
			response = new ResponseEntity<>("Updated todo",HttpStatus.OK);
		}else {
			response = new ResponseEntity<>("Todo not found",HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return response;
	}
	
	@DeleteMapping("/{todoId}")
	public ResponseEntity<String> deleteToDo(@PathVariable long todoId) throws UnprocessableEntityHttpException {
		service.deleteToDo(todoId);
		
		return new ResponseEntity<>("Deleted todo",HttpStatus.OK);
	}
}
