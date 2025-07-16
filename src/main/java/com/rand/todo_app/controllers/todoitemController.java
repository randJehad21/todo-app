package com.rand.todo_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class todoitemController {

    private final Logger logger = LoggerFactory.getLogger(todoitemController.class);

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("Request to GET index");
        return new ModelAndView("index"); // will look for index.html in templates
    }
}
