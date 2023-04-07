package com.dsabyte.dsa.ds.stack;

public interface StackBase<T> {
	void push(T item);
	void pop();
	T peek();
	boolean isEmpty();
	boolean isFull();
}
