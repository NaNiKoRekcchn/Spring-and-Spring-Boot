package com.example.controller;

import com.example.model.UserSpringCRUDJPA;
import org.springframework.stereotype.Controller;
import com.example.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserSpringCRUDJPA createUser(@RequestBody UserSpringCRUDJPA user){
       return userService.createUser(user);
    }
}
