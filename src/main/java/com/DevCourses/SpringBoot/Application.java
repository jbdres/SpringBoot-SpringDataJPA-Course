package com.DevCourses.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        var ctx = SpringApplication.run(Application.class, args);

        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.getJavaVersion());
        System.out.println(myFirstService.getOSName());
        System.out.println(myFirstService.getApplicationProperty());

    }

}
