package com.todo.inmemory.services;

import java.util.ArrayList;

import models.ToDo;

public interface ToDoService {
	public ToDo getToDo(long todoId);
	public ArrayList<ToDo> getToDos();
	public void createToDo(ToDo todo);
	public boolean updateToDo(ToDo todo);
	public boolean deleteToDo(long todoId);
}
