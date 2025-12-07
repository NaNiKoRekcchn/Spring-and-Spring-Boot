package com.example.LooseCoupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("smsService")
@Primary
public class SMsService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("SMS : " + message);
    }
}
