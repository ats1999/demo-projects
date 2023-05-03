package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.ToDoModel;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Override
	public ToDoModel createToDo(ToDoModel todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToDoModel[] getToDos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToDoModel getToDo(String todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteToDo(String todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changesStatus(String todoId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
