package com.example.config;

import com.example.db.DataBaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This tells Spring: "Hey, this class has configuration settings!"
@Configuration
// This tells Spring: "Scan all classes in com.example package to find beans"
@ComponentScan("com.example")
public class AppConfig {

    // @Bean tells Spring: "Create and manage this object for me"
    // initMethod: Spring will call init() after creating the object
    // destroyMethod: Spring will call cleanUp() before app shutdown
    @Bean(initMethod = "init", destroyMethod = "cleanUp")
    public DataBaseConnection dbConnect(){
        // Create new object and give it to Spring to manage
        return new DataBaseConnection();
    }
}
