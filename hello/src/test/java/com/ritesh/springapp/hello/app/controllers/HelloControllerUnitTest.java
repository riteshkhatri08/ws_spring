package com.ritesh.springapp.hello.app.controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

@WebMvcTest(HelloController.class)
public class HelloControllerUnitTest {
  @Autowired
    MockMvc mockMvc;

    @MockBean
    Model model;

    @Test
    public void autowiringWorked(){
        assertNotNull(mockMvc,"Testing Autowiring");
    }


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
