package com.DevCourses.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        var ctx = SpringApplication.run(Application.class, args);

        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.getCountry());
        System.out.println(myFirstService.getYear());
        System.out.println(myFirstService.getProfile());
        System.out.println(myFirstService.getAge());
        System.out.println(myFirstService.getLaptopManufacter());
        System.out.println(myFirstService.getLaptopModel());
        System.out.println(myFirstService.getLaptopProcessor());
        System.out.println(myFirstService.getLaptopInstalledRAM());
        System.out.println(myFirstService.getLaptopSystemType());
        System.out.println(myFirstService.getPhoneManufacter());
        System.out.println(myFirstService.getPhoneModel());
        System.out.println(myFirstService.getPhoneCameraResolution());
        System.out.println(myFirstService.getPhoneSoVersion());

    }

}
