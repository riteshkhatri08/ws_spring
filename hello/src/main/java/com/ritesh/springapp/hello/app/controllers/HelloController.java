package com.ritesh.springapp.hello.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // For themeleaf to works
// @RestController // For only apis
public class HelloController {
    
    // @RequestMapping(value = "hello", method= RequestMethod.GET)
    @GetMapping(value = "hello")
    public String sayHello(@RequestParam(defaultValue= "World") String name
                    , Model model){
                        // Spring takes all atrributes of model
                        // Adds them to httpsevelt request 
                        // Forward to view
        model.addAttribute("user", name);
        // System.out.println(model.getClass().getName());
        // return "Hello "+name +" !";  // Used with rest controller 
        return "welcome"; // return src/main/resources/templates/welcome.html
    }

       
//     @GetMapping(value = "hola")
//     public String sayHola(String name){
//         return "Hola "+ name + " !";
//     }
}
