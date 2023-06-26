package com.example.todospringhibernate.repository;

import com.example.todospringhibernate.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {

}
