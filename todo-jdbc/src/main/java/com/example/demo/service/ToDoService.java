package com.example.demo.service;

import com.example.demo.model.ToDoModel;

public interface ToDoService {
	public ToDoModel createToDo(ToDoModel todo);
	public ToDoModel[] getToDos();
	public ToDoModel getToDo(String todoId);
	public String deleteToDo(String todoId);
	public String changesStatus(String todoId, String status);
}
