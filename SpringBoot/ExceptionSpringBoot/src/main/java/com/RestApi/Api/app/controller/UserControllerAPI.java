package com.RestApi.Api.app.controller;

import com.RestApi.Api.app.Service.UserService;
import com.RestApi.Api.app.model.UserDataAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userCRUD")
public class UserControllerAPI {
    private UserService userservice = new UserService();

    public UserControllerAPI(UserService userservice) {
        this.userservice = userservice;
    }

//    ALL UserList
    @GetMapping
    public ResponseEntity<List<UserDataAPI>> getUsers(){
        List<UserDataAPI> UserList = userservice.getUserList();
        return new ResponseEntity<>(UserList,HttpStatus.ACCEPTED);
    }
//  Create User
    @PostMapping
    public ResponseEntity<UserDataAPI> createUser(@RequestBody UserDataAPI user){
          UserDataAPI createdUser = userservice.createUser(user);
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
//  Update User
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDataAPI user){
        UserDataAPI updatedUser = userservice.updateUser(user);
        if(updatedUser==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
    }
//   Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
       boolean isDeleted = userservice.deleteUserWithId(id);
       if (!isDeleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<>("User Deleted",HttpStatus.ACCEPTED);
    }

//  Get user by id , id coming from Url
    @GetMapping("/pathVariabelNotRequried/{userid}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "userid",required = false) int id){
        UserDataAPI user = userservice.getUserById(id);
        if(user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok().body(user);
    }

//    Request Parameter (Used for Search and filter etc.)
    @GetMapping("/search")
        public ResponseEntity<List<UserDataAPI>> listOfUser(
                @RequestParam(required = false,defaultValue = "Mustaali King") String name
        ){
        System.out.println(name);
        List<UserDataAPI> searchUser = userservice.getSearchUser(name);
        return new ResponseEntity<>(searchUser,HttpStatus.ACCEPTED);
    }


//    API headers are key-value pairs that accompany every HTTP request and response, providing essential metadata and context beyond the main body or URL.
    @GetMapping("/info/{id}")
    public String getInfo(
            @RequestHeader("User-Agent") String userAgent,
            @PathVariable("id") int id,
            @RequestParam(defaultValue = "Mustaali") String name
    ){
        return "User-Agent: " + userAgent + "ID: " + id + "Name: " + name ;
    }



}
