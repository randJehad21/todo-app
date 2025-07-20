package com.rand.todo_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rand.todo_app.models.toDoItem;
import com.rand.todo_app.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class toDoItemDataLoader implements CommandLineRunner{
    
     private final Logger logger = LoggerFactory.getLogger(toDoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            toDoItem todoItem1 = new toDoItem("Finish Todo App");
            toDoItem todoItem2 = new toDoItem("Start new website");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2); 
        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }
}
