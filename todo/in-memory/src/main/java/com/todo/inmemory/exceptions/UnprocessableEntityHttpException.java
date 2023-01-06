package com.todo.inmemory.exceptions;

@SuppressWarnings("serial")
public class UnprocessableEntityHttpException extends Exception {
	public UnprocessableEntityHttpException(String msg){
		super(msg);
	}
}
