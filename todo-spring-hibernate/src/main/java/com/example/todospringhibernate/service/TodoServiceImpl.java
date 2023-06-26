package com.example.todospringhibernate.service;

import com.example.todospringhibernate.model.Todo;
import com.example.todospringhibernate.model.UpdateTodoDTO;
import com.example.todospringhibernate.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    TodoRepository todoRepository;

    TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo createTodo(Todo todo) {
        todo.setStatus("TODO");
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Iterable<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo updateTodo(Long id, UpdateTodoDTO updateTodoDTO) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isEmpty()) {
            return null;
        }

        Todo todoToUpdate = todo.get();

        if (updateTodoDTO.todo() != null && !updateTodoDTO.todo().isEmpty()) {
            todoToUpdate.setTodo(updateTodoDTO.todo());
        }

        if (updateTodoDTO.status() != null && !updateTodoDTO.status().isEmpty()) {
            todoToUpdate.setStatus(updateTodoDTO.status());
        }

        return todoRepository.save(todoToUpdate);
    }

    @Override
    public String deleteTodo(Long id) {
        if (todoRepository.findById(id).isEmpty()) {
            return "Todo not found!";
        }

        todoRepository.deleteById(id);
        return "Delete todo " + id;
    }

    @Override
    public Long count() {
        return todoRepository.count();
    }

    @Override
    public List<Todo> search(String filter) {
        if(filter == null || filter.isEmpty()){
            return new ArrayList<>();
        }

        return todoRepository.search(filter);
    }
}
