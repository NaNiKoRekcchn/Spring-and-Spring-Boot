package com.example.LooseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServices {
//    @Autowired not good practice
    public NotificationService notificationService;

    public UserServices() {}
//    @Autowired // used when more than one constructor is present in class
//    public UserServices(@Qualifier("emailService") NotificationService notificationService){
//        this.notificationService = notificationService;
//    }
    @Autowired
    public UserServices( NotificationService notificationService){
        this.notificationService = notificationService;
    }


    public void Notify(String message){
        notificationService.send(message);
    }


}
