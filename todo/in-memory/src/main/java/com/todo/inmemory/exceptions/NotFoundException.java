package com.todo.inmemory.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {
	public NotFoundException(String msg) {
		super(msg);
	}
}
