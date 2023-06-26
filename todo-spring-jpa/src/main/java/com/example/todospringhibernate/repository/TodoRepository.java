package com.example.todospringhibernate.repository;

import com.example.todospringhibernate.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {
    @Query("SELECT T FROM Todo T WHERE T.todo LIKE %?1%")
    List<Todo> search(String filter);
}
