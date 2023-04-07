package com.dsabyte.java.generic;

import java.util.Arrays;
import java.util.List;

// https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html
class Calculator {
	// list can be of Number and sub-type of Number
	static double sumOfList(List<? extends Number> list) {
		double sum = 0;
		for (Number el : list) {
			sum += el.doubleValue();
		}
		return sum;
	}
}

public class BoundedWildCard {

	public static void main(String[] args) {
		System.out.println(Calculator.sumOfList(Arrays.asList(1, 2, 3, 4)));
		System.out.println(Calculator.sumOfList(Arrays.asList(1.0, 2.5, 3.1, 4.1)));
	}

}
