package com.example.LooseCoupling;

public class SMsService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("SMS : " + message);
    }
}
