package com.springprojects.inputvalidation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class RegisterModel {
	
	@Size(min=10,max=20)
	private String name;
	
	@Min(18)
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
