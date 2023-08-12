package com.ritesh.restclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.restclient.json.AstroResponse;
import com.ritesh.restclient.services.AstroService;

@RestController
public class AstroController {
    @Autowired
    AstroService astroService;


    @GetMapping("/astros")
    public AstroResponse getAstrosInSpace() {
        return this.astroService.getAstroResponse();
    }

}
