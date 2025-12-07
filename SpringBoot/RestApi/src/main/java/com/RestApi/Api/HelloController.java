package com.RestApi.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String SayHello(){
        return "Hi How are u Mustaali";
    }
//Request Mapping At Method Level
//    @GetMapping("/user")
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public List<UserData> userData(){
    return Arrays.asList(
            new UserData("John Doe", "1", "john.doe@example.com"),
            new UserData("Jane Smith", "2", "jane.smith@example.com"),
            new UserData("Mike Johnson", "3", "mike.johnson@example.com"),
            new UserData("Sarah Williams", "4", "sarah.williams@example.com"),
            new UserData("David Brown", "5", "david.brown@example.com")
    );
    }
}
