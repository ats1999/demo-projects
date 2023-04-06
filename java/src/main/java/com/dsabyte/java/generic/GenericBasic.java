package com.dsabyte.java.generic;

class ShowTime {
	int item;

	public ShowTime(int item) {
		this.item = item;
	}

	public void show() {
		System.out.println("Simple show time: " + this.item);
	}
}

class ShowTimeGeneric<T> {
	T item;

	ShowTimeGeneric(T item) {
		this.item = item;
	}

	public void show() {
		System.out.println("Generic show time: " + item.getClass().getName() + ": " + this.item);
	}
}

public class GenericBasic {

	public static void main(String[] args) {
		ShowTime showTime = new ShowTime(12);
		// ShowTime showTime = new ShowTime("@dsabyte"); // won't work
		showTime.show();

		ShowTimeGeneric<String> showTimeGenericString = new ShowTimeGeneric<String>("@dsabyte");
		showTimeGenericString.show();

		ShowTimeGeneric<Integer> showTimeGenericInt = new ShowTimeGeneric<Integer>(1);
		showTimeGenericInt.show();
	}

}
