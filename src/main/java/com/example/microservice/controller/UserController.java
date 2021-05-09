package com.example.microservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.microservice.service.GreetingService;

/**
 * TODO
 * */
@RestController
@CrossOrigin
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/users")
public class UserController {

    private final GreetingService greetingService;

    @GetMapping("/{name}")
    public String getByName(@PathVariable("name") final String name) {
       return greetingService.sayHi(name);
    }
}
