package com.example.demo;

import com.example.LooseCoupling.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {
    private NotificationService notificationService;

    public LifeCycleBean(NotificationService notificationService) {
        System.out.println("CONSTRUCTOR CALLED : DEPENDENCY INJECTED");
        this.notificationService = notificationService;
    }

    public void init(){
        System.out.println("INIT called : Bean Initialized");
        notificationService.send("Hello From Init()");
    }

    public  void performTask(){
        System.out.println("Ready for use");
    }

    public void cleanUp(){
        System.out.println("cleanUp begin called");
    }
}
