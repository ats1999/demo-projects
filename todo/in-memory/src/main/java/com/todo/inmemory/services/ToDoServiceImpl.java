package com.todo.inmemory.services;

import java.util.ArrayList;
import java.util.UUID;

import com.todo.inmemory.models.ToDo;
import com.todo.inmemory.repositories.ToDoRepositery;

public class ToDoServiceImpl implements ToDoService{
	ToDoRepositery repo = new ToDoRepositery();
	
	@Override
	public ToDo getToDo(long todoId) {
		return repo.getToDoById(todoId);
	}

	@Override
	public ArrayList<ToDo> getToDos() {
		return repo.getAllToDo();
	}

	@Override
	public void createToDo(ToDo todo) {
		long uuid = UUID.randomUUID().getLeastSignificantBits();
		todo.setId(Math.abs(uuid));
		todo.setStatus("TODO");
		repo.saveToDo(todo);
	}

	@Override
	public boolean updateToDo(ToDo todo) {
		return repo.updateToDo(todo);
	}

	@Override
	public boolean deleteToDo(long todoId) {
		return repo.deleteToDoById(todoId);
	}
	
}
