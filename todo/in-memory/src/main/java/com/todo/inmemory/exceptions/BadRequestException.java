package com.todo.inmemory.exceptions;

@SuppressWarnings("serial")
public class BadRequestException extends Exception {
	public BadRequestException(String msg) {
		super(msg);
	}
}
