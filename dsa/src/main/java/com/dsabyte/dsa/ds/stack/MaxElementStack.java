package com.dsabyte.dsa.ds.stack;

import java.io.*;
import java.util.*;
class Result {

    
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack =  new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        
        List<Integer> ans = new ArrayList<>();
        
        for (String string : operations) {
            String op = string.split(" ")[0];
            
            switch(op){
                case "1":
                    stack.push(Integer.valueOf(string.split(" ")[1]));
                    
                    if(maxStack.isEmpty() || maxStack.peek() <= stack.peek()){
                        maxStack.push(stack.peek());
                    }
                    
                    break;
                case "2":
                    if(stack.peek() >= maxStack.peek()){
                        maxStack.pop();
                    }
                    stack.pop();
                    break;
                case "3":
                    ans.add(maxStack.peek());
                    break;
            }
        }
        
        
        return ans;
    }

}

public class MaxElementStack {
    public static void main(String[] args) throws IOException {
    	List<String> ops = new ArrayList<>() ;
        
    	ops.add("1 97");
    	ops.add("2");
    	ops.add("1 20");
    	ops.add("2");
    	ops.add("1 26");
    	ops.add("1 20");
    	ops.add("2");
    	ops.add("3");
    	ops.add("1 91");
    	ops.add("3");
    	
        List<Integer> res = Result.getMax(ops);
        
        for(Integer i:res) {
        	System.out.println(i);
        }

    }
}
