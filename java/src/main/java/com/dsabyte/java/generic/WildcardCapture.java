package com.dsabyte.java.generic;

import java.util.Arrays;
import java.util.List;

class WildcardError{
	void add(List<?> list) {
//		list.set(0, list.get(0)); // won't work
		addHelper(list);
	}
	
	private <T> void addHelper(List<T> list) {
		list.set(0, list.get(0));
	}
}

// https://docs.oracle.com/javase/tutorial/java/generics/capture.html
public class WildcardCapture {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		WildcardError wildcardError = new WildcardError();
		wildcardError.add(list);
		
	}

}
