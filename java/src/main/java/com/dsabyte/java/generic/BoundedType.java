package com.dsabyte.java.generic;

public class BoundedType {
	// T extends Number -> this can be applied to even type(classes)
	static <T extends Number> boolean isEven(T num) {
		return num.intValue() % 2 == 0;
	}

	public static void main(String[] args) {
		System.out.println("5 is even: " + isEven(5));
		System.out.println("4 is even: " + isEven(4));
		System.out.println("4.8 is even: " + isEven(4.8)); // 4.8 -> 4 
	}

}
