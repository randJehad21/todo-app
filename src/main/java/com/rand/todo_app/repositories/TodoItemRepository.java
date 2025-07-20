package com.rand.todo_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rand.todo_app.models.toDoItem;

public interface TodoItemRepository extends CrudRepository<toDoItem,Long> {

    
    
}
