package org.example.test;

public class Main {
    public static void main(String[] args) {
        try{
            int a = 9/0;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }finally {
            System.out.println("I a here");
        }
    }
}
