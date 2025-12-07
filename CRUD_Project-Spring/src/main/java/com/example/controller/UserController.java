package com.example.controller;

import org.springframework.stereotype.Controller;
import com.example.services.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userservice;

    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    public void createUser(String name){
        userservice.addUser(name);
    }

    public void listUser(){
        List<String> userList = userservice.getAllUser();
        System.out.println("All User " + userList);

    }
}
