package com.ritesh.springapp.hello.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.springapp.hello.app.json.Greeting;

@RestController
@RequestMapping(value = "/rest")
public class HelloRestController {

    @GetMapping(value = "/greet")
    public Greeting greet(@RequestParam(defaultValue = "World") String name) {

        return new Greeting("Hello " + name + "!");

    }

    @PostMapping(value = "/greet")
    @ResponseStatus(HttpStatus.CREATED)
    public Greeting greetPost(@RequestBody Greeting greeting) {

        return new Greeting(String.format("Hey %s !", greeting.getMessage()));
    }

}
