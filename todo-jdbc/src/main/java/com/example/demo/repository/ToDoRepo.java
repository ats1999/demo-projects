package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.ToDoModel;

public interface ToDoRepo {
	public String createToDo(String name);
	public List<ToDoModel> getToDos();
	public ToDoModel getToDo(String todoId);
	public String deleteToDo(String todoId);
	public String changesStatus(String todoId, String status);
}
