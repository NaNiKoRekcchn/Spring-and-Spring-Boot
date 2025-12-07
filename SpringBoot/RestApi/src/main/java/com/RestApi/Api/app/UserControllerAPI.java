package com.RestApi.Api.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userCRUD")
public class UserControllerAPI {
    private Map<Integer, UserDataAPI> userDB = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<UserDataAPI>> getUsers(){
        return new ResponseEntity<>(new ArrayList<>(userDB.values()),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<UserDataAPI> createUser(@RequestBody UserDataAPI user){
        System.out.println(user.getEmail());
        userDB.putIfAbsent(user.getId(),user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDataAPI user){
        if(!userDB.containsKey(user.getId())){
            return new ResponseEntity<>("Invalid User",HttpStatus.FORBIDDEN);
        }
           userDB.put(user.getId(),user);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        if(!userDB.containsKey(id)){
            return new ResponseEntity<>("User is not Found",HttpStatus.FORBIDDEN);
        }
        userDB.remove(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }

//    @GetMapping({"/user","/user/{id}"})
//    Above syntax is also valid
//    Dynamic Url
//    Using Path Variable
    @GetMapping("/pathVariabelNotRequried/{userid}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "userid",required = false) int id){
        if(!userDB.containsKey(id)){
            return new ResponseEntity<>("User Not Found",HttpStatus.FORBIDDEN);
        }
//        return new ResponseEntity<>(userDB.get(id),HttpStatus.OK);
        return ResponseEntity.ok().body(userDB.get(id));
    }

//    we can pass and use Multiple path variable in url
//    Used for sending data like id to the url
    @GetMapping("/{id}/order/{orderid}")
    public ResponseEntity<?> getUserById(
        @PathVariable int id,
        @PathVariable int orderid
    ){
        if(!userDB.containsKey(id)){
            return new ResponseEntity<>("User Not Found",HttpStatus.FORBIDDEN);
        }
        System.out.println("ORDER ID : "+orderid);
//      return new ResponseEntity<>(userDB.get(id),HttpStatus.OK);
        return ResponseEntity.ok().body(userDB.get(id));
    }
//    Request Parameter (Used for Search and filter etc.)
    @GetMapping("/search")
        public ResponseEntity<List<UserDataAPI>> listOfUser(@RequestParam(required = false,defaultValue = "Mustaali King") String name){
        System.out.println(name);
        List<UserDataAPI> listofuser = userDB.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).toList();
        return new ResponseEntity<>(listofuser,HttpStatus.ACCEPTED);
    }
    //    Request Parameter (Multiple Parameters)
    @GetMapping("/multipleParams")
        public ResponseEntity<List<UserDataAPI>> multipleRequestParam(
                @RequestParam(required = false,defaultValue = "Mustaali King") String name,
                @RequestParam(required = false,defaultValue = "kanchwalamustaali@gmail") String email
    ){
        System.out.println(name);
        List<UserDataAPI> listofuserwithMultipleParams = userDB.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .toList();
        return new ResponseEntity<>(listofuserwithMultipleParams,HttpStatus.ACCEPTED);
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
