package com.dsabyte.java.generic;

public class BoundedTypeGreaterNumber {

	static <T extends Number> int countGreaterThan1(T[] ar, T el) {
		int count = 0;

		for (int i = 0; i < ar.length; i++) {
			if (ar[i].doubleValue() > el.doubleValue()) {
				count++;
			}
		}

		return count;
	}

	static <T extends Comparable<T>> int countGreaterThan2(T[] ar, T el) {
		int count = 0;

		for (T curEl : ar) {
			if (curEl.compareTo(el) > 0) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
//		System.out.println(BoundedTypeGreaterNumber.countGreaterThan1(new Number[] { 1, 4, 5, 6, 7, 9, 10 }, 5));

//		System.out.println(BoundedTypeGreaterNumber.countGreaterThan2(new Number[] { 1, 4, 5, 6, 7, 9, 10 }, 5));

		Integer ar[] = new Integer[] {2,3,4,5};
		System.out.println(countGreaterThan2(ar,Integer.valueOf(4)));
	}

}
