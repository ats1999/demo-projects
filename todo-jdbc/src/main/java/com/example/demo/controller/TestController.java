package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

record  User(String name, int age){

}
@RestController
public class TestController {
    @GetMapping("/test")
    public User getUser(){
        User u = new User("Rahul Kumar Thakur",23);
        return  u;
    }
}
