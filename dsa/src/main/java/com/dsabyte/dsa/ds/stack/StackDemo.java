package com.dsabyte.dsa.ds.stack;

public class StackDemo {
	static class Stack<T> implements StackBase<Integer> {
		private final Integer[] stack;
		private int top = -1;

		Stack(final int size) {
			stack = new Integer[size];
		}

		public void push(final Integer item) {
			if (isFull()) {
				System.out.println("Stack is full...");
				return;
			}
			stack[++top] = item;
		}

		public void pop() {
			if (isEmpty()) {
				System.out.println("Stack is empty...");
				return;
			}
			top--;
		}

		public Integer peek() {
			if (isEmpty()) {
				System.out.println("Stack is empty...");
				return null;
			}

			return stack[top];
		}

		public boolean isEmpty() {
			return top < 0;
		}

		public boolean isFull() {
			return top == stack.length - 1;
		}

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(10);
		stack.peek();
		stack.push(4);
		System.out.println(stack.peek());
		stack.push(4);
		stack.push(3);
		stack.push(89);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}

}
