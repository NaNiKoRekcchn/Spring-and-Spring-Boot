package com.example.LooseCoupling;

import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("Email : "+message);
    }
}
