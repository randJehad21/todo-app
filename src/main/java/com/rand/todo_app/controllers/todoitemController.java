package com.rand.todo_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.rand.todo_app.models.toDoItem;
import com.rand.todo_app.repositories.TodoItemRepository;

import jakarta.validation.Valid;
import org.springframework.ui.Model;

import java.time.Instant;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class todoitemController {
    private final Logger logger = LoggerFactory.getLogger(todoitemController.class);

// pull all itens from the DB with name todoItems
    @Autowired
    private TodoItemRepository todoItemRepository;    
    
    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("Request to GET index");
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView; // will look for index.html in templates
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid toDoItem todoItem, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("todoItem", todoItem);
            return "add-todo-item";
        }        
        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
    

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid toDoItem todoItem, BindingResult result, Model model){
        if(result.hasErrors()){
            todoItem.setId(id);
            return "update-todo-item";

        }

        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";

    }
    
}
