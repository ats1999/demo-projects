package com.dsabyte.java.generic;

public class GenericMethod {
	static <T1> T1 print(T1 item) {
		return item;
	}

	public static void main(String[] args) {
		System.out.println(print("@dsabyte"));
		System.out.println(print(0));
	}

}
