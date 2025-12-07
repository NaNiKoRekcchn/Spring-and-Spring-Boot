package com.example.demo;

import com.example.LooseCoupling.NotificationService;
import com.example.LooseCoupling.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] a) {
        System.out.println("Starting Spring Application context");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        System.out.println("Retriving lifeCycle Bean");
        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);

        lifeCycleBean.performTask();

        System.out.println("Closing Spring Context");
    }
}
