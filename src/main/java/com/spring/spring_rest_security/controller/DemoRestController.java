package com.spring.spring_rest_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoRestController
 * <p>
 * REST controller for demonstration and health-check purposes.
 * Exposes sample endpoints under {@code /test} to verify that the application
 *  is running and handling HTTP requests properly.
 * </p>
 * 
 * @author Felisa Bascug
 */
@RestController 
@RequestMapping ("/test")
public class DemoRestController {

    /**
     * Returns a basic greeting message to verify endpoint connectivity.
     *
     * @return the greeting string {@code "Hello World!"}
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
        
}
