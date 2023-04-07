package com.dsabyte.java.generic;

class Demo{
	<T> Demo(T t){
		System.out.println(t.getClass().getName());
	}
}
public class TypedConstructor {

	public static void main(String[] args) {
		new Demo(9);
		new Demo("@dsabyte");
	}

}
