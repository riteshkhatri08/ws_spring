package com.ritesh.springapp.hello.app.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ritesh.springapp.hello.app.json.Greeting;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloRestControllerIntegrationTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void greetWithoutName() {
        ResponseEntity<Greeting> response = testRestTemplate.getForEntity("/rest/greet", Greeting.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        Greeting responseGreeting = response.getBody();
        assertNotNull(responseGreeting, "checking responseGreeting");
        assertEquals("Hello World!", responseGreeting.getMessage());
    }

    // @Test
    // public void greetWithName(@Autowired TestRestTemplate testRestTemplate) {

    // }

    @Test
    public void greetPostWithName() {
        String message = "Ritesh";
        Greeting requesGreeting = new Greeting(message);

        ResponseEntity<Greeting> response = testRestTemplate.postForEntity("/rest/greet", requesGreeting,
                Greeting.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        Greeting responseGreeting = response.getBody();
        assertNotNull(responseGreeting, "checking responseGreeting");
        assertEquals(String.format("Hey %s !", message), responseGreeting.getMessage());
    }

}
