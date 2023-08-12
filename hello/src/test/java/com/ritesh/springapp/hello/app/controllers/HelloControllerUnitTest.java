package com.ritesh.springapp.hello.app.controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class HelloControllerUnitTest {
 

    @Test
    void testSayHello() {
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.sayHello("Ritesh", model);
        assertAll(

                () -> assertEquals("welcome", result, "Successful"),
                () -> assertEquals("Ritesh", model.getAttribute("user"), "succesfull"));

    }
}
