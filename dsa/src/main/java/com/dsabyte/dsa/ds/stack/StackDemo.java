package com.dsabyte.dsa.ds.stack;

public class StackDemo {
	static class Stack{
		int ar[];
		int top;
		
		Stack(int size){
			ar = new int[size];
			top = -1;
		}
		
		void push(int item) {
			ar[++top] = item;
		}
		
		void pop() {
			top--;
		}
		
		int peek() {
			return ar[top];
		}
		
		boolean isEmpty() {
			return top == -1;
		}
		
		boolean isFull() {
			return top == (ar.length-1);
		}
		
	}
	public static void main(String[] args) {
		
	}

}
