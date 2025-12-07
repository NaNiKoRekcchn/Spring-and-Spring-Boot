package com.RestApi.Api.app.Service;


import com.RestApi.Api.app.exception.UserNotFoundException;
import com.RestApi.Api.app.model.UserDataAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
//    Used to store user object instead of DB
    private Map<Integer, UserDataAPI> userDB = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

//    Create new user , data come from controller
    public UserDataAPI createUser(UserDataAPI user) {
        logger.trace("Creating User.......... Trace");
        logger.debug("Creating User.......... Debug");
        logger.info("Creating User..........  Info");
        logger.warn("Creating User..........  Warn");
        logger.error("Creating User..........  Error");
        System.out.println(user.getEmail());
        userDB.putIfAbsent(user.getId(),user);
        return user;
    }

//    Sending all user
    public List<UserDataAPI> getUserList() {
        if(userDB.isEmpty()){
            throw new NullPointerException("No user Found in DB");
        }
        return userDB.values().stream().toList();
    }

//  Update User
    public UserDataAPI updateUser(UserDataAPI user) {
        if(!userDB.containsKey(user.getId())){
            logger.error("Cannot find user with id {} ",user.getId());
            throw new UserNotFoundException("User with ID : "+user.getId() + " Does not exsit");
//            return null;
        }
        userDB.put(user.getId(),user);
        return user;
    }
//    Delete User
    public boolean deleteUserWithId(int id) {
        if(!userDB.containsKey(id)){
            return false;
        }
        userDB.remove(id);
        return true;
    }
//  Get user by id
    public UserDataAPI getUserById(int id) {
        if(!userDB.containsKey(id)){
            return null;
        }
        return userDB.get(id);
    }
//    Search User
    public List<UserDataAPI> getSearchUser(String name) {
        if(name == null) return null;
        return userDB.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).toList();
    }


}
