package com.example.todospringhibernate.controller;

import com.example.todospringhibernate.model.Todo;
import com.example.todospringhibernate.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/test")
    public List<Todo> test(@RequestParam String filter){
        return todoRepository.search(filter);
    }
}
