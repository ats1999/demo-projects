package com.example.todospringhibernate.service;

import com.example.todospringhibernate.model.Todo;
import com.example.todospringhibernate.model.UpdateTodoDTO;
import java.util.Optional;

public interface TodoService {
    Todo createTodo(Todo todo);
    Optional<Todo> getTodo(Long id);
    Iterable<Todo> getAllTodo();
    Todo updateTodo(Long id,UpdateTodoDTO updateTodoDTO);
    String deleteTodo(Long id);
}
