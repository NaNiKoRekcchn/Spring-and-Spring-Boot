package com.example.demo;

import com.example.LooseCoupling.NotificationService;
import com.example.LooseCoupling.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] a) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        GreetingService greet = (GreetingService) context.getBean("myBean");
        greet.sayHello();

        UserServices userService = (UserServices) context.getBean("userService");
        userService.NotifyEmail("Email notification using Bean");
        userService.NotifySMS("SMA");

        UserServices email = (UserServices) context.getBean("userServiceEmail");
        UserServices sms = (UserServices) context.getBean("userServiceSMS");
        email.Notify("Email services using diffrent bean");
        sms.Notify("SMS services using diffrent bean");
        sms.Notify("SMS services using Constructor");

    }
}
