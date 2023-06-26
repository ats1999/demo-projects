package com.example.todospringhibernate.controller;

import com.example.todospringhibernate.model.Todo;
import com.example.todospringhibernate.model.UpdateTodoDTO;
import com.example.todospringhibernate.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {
    TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("/{id}")
    Optional<Todo> getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @GetMapping("/all")
    Iterable<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @PutMapping("/{id}")
    Todo updateTodo(@PathVariable Long id, @RequestBody UpdateTodoDTO updateTodoDTO) {
        return todoService.updateTodo(id,updateTodoDTO);
    }

    @DeleteMapping("/{id}")
    String deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }

    @GetMapping("/count")
    Long count(){
        return todoService.count();
    }
}
