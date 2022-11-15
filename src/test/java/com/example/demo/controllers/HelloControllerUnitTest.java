package com.example.demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(HelloController.class)
public class HelloControllerUnitTest {
    @Autowired
    private MockMvc mvc;


    @Test
    @DisplayName("this is my first test")
    public void sayHello() {
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.sayHello("World", model);
        assertAll(
                () -> assertEquals("hello", result),
                () -> assertEquals("World", model.getAttribute("user"))
        );
    }
}
