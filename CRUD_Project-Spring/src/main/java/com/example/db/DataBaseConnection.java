package com.example.db;

import java.util.ArrayList;
import java.util.List;

// Not using @Component because we need init() to run first
// @Bean in AppConfig gives us more control over when init() is called
public class DataBaseConnection {

    // Just declared, not initialized yet (null at this point)
    private List<String> users;

    // Spring calls this automatically after creating the object
    // This is where we set up everything (like connecting to DB)
    public void init(){
        users = new ArrayList<>();  // Now the list is ready to use!
        System.out.println("Database Connected (Simulated)");
    }

    // Get all users from the list
    public List<String> getUsers(){
        return users;
    }

    // Add a new user to the list
    public void addUser(String user){
        System.out.println(users.add(user));
    }

    // Spring calls this before shutting down the app
    // This is where we clean up resources (like closing DB connection)
    public void cleanUp(){
        System.out.println("Database Disconnected (Simulated)");
    }
}
