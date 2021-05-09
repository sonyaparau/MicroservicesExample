package com.example.microservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.microservice.service.UserService;

/**
 * TODO
 * */
@RestController
@CrossOrigin
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") final Long id) {
       return userService.findUser(id);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") final Long id) {
//        userService.deleteUser(id);
//    }
//
//    @PostMapping
//    public void add(@RequestBody final UserDto userDto) {
//        userService.addUser(userDto);
//    }
}
