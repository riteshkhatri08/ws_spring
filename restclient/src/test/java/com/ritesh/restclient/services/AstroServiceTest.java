package com.ritesh.restclient.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ritesh.restclient.json.AstroResponse;

@SpringBootTest
public class AstroServiceTest {
    private final Logger logger = LoggerFactory.getLogger(AstroServiceTest.class);
    @Autowired
    AstroService service;

    @Test
    void testGetAstroResponse() {
        AstroResponse response = service.getAstroResponse();
        logger.info(response.toString());
        assertTrue(response.getNumber() > 0);
        assertEquals("success", response.getMessage());
        assertEquals(response.getNumber(), response.getPeople().size());

        response.getPeople().forEach(
                assignment -> logger.info(assignment.getName() + " is on " + assignment.getCraft() + " craft."));

    }

    @Test
    void testGetAstroResponseRestTemplate() {
        AstroResponse response = service.getAstroResponseRestTemplate();
        logger.info(response.toString());
        assertTrue(response.getNumber() > 0);
        assertEquals("success", response.getMessage());
        assertEquals(response.getNumber(), response.getPeople().size());

        response.getPeople().forEach(
                assignment -> logger.info(assignment.getName() + " is on " + assignment.getCraft() + " craft."));

    }
}
