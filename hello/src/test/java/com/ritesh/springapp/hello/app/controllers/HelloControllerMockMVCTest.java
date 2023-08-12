package com.ritesh.springapp.hello.app.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.ui.Model;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMVCTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Model model;

    @Test
    public void autowiringWorked() {
        assertNotNull(mockMvc, "Testing Autowiring");
        assertNotNull(model, "Testing Autowiring");
    }

    @Test
    public void testSayHelloWithoutName() throws Exception {

        RequestBuilder builder = get("/hello").accept(MediaType.TEXT_HTML);
        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "World"));
    }

    @Test
    public void testSayHelloWithName() throws Exception {

        RequestBuilder builder = get("/hello").param("name", "Ritesh")
                .accept(MediaType.TEXT_HTML);
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "Ritesh"));
    }

}
