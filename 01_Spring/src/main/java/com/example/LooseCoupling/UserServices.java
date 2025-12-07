package com.example.LooseCoupling;

public class UserServices {
    public NotificationService notificationService;
    public NotificationService emailNotificationService;
    public NotificationService smsNotificationService;


    public void setEmailNotificationService(NotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    public void setSmsNotificationService(NotificationService smsNotificationService) {
        this.smsNotificationService = smsNotificationService;
    }

    public String message;

    public UserServices() {
    }

    public UserServices(NotificationService smsNotificationService) {
        this.smsNotificationService = smsNotificationService;
    }

    public UserServices(NotificationService notificationService, String message){
        this.notificationService = notificationService;
        this.message = message;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public void Notify(String message){
        notificationService.send(message);
    }

    public void NotifyEmail(String message){
        emailNotificationService.send(message);
    }
    public void NotifySMS(String message){
        smsNotificationService.send(message);
    }
}
