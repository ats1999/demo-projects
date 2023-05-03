package com.example.demo.repository;

import com.example.demo.model.ToDoModel;

public interface ToDoRepo {
	public ToDoModel createToDo(ToDoModel todo);
	public ToDoModel[] getToDos();
	public ToDoModel getToDo(String todoId);
	public String deleteToDo(String todoId);
	public String changesStatus(String todoId, String status);
}
