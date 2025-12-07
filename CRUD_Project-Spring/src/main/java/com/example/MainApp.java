package com.example;

import com.example.config.AppConfig;
import com.example.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args){
//        Creating Application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        getting bean of controller
        UserController controller = context.getBean(UserController.class);

//        Creating user
//        the flow will be main will call => controller will call => service will call => repository will call => Database connection
            controller.createUser("Mustaali");
            controller.createUser("Shubham");
            controller.createUser("Soham");
            controller.createUser("Hussain");
            controller.listUser();
    }
}
