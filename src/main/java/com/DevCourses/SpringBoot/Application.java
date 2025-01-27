package com.DevCourses.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(Application.class, args);

		/*
         Getting the @Bean by class and name
         MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
         MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
         System.out.println(myFirstClass.sayHello());
        */

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());

	}

}
