package com.dsabyte.java.generic;

import java.util.Arrays;
import java.util.List;

public class UnBoundedWildcard {
	
	// https://docs.oracle.com/javase/tutorial/java/generics/unboundedWildcards.html
	static void printList(List<?> list) {
		for(Object el: list) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		printList(Arrays.asList("@dsabyte","Rahul Kumar","Good"));
		printList(Arrays.asList(1,2,3,4,5));
	}

}
