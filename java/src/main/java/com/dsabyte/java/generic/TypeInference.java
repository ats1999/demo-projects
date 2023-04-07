package com.dsabyte.java.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypeInference {
	
	static <T> List<T> getList(){
		return new ArrayList<T>();
	}
	
	static <T> List<T> getList2(List<Integer> it){
		return new ArrayList<T>();
	}
	public static void main(String[] args) {
		List<String> list1 = TypeInference.<String>getList(); // before java 7
		List<String> list2 = getList(); // work in java 7+
		
		// prior to java 8
		List<String> list3 = getList2(Collections.<Integer>emptyList());
		getList2(TypeInference.<Integer>getList());
		
		// the below inference of method args is added in java 8+
		// TODO: this is supposed to work in java 8+
//		getList2(getList());
		
		System.out.println(System.getProperty("java.version"));
	}

}
