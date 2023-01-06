package com.todo.inmemory.services;

import java.util.ArrayList;

import com.todo.inmemory.exceptions.UnprocessableEntityHttpException;
import com.todo.inmemory.models.ToDo;

public interface ToDoService {
	public ToDo getToDo(long todoId);
	public ArrayList<ToDo> getToDos();
	public void createToDo(ToDo todo);
	public boolean updateToDo(ToDo todo);
	public void deleteToDo(long todoId) throws UnprocessableEntityHttpException;
}
