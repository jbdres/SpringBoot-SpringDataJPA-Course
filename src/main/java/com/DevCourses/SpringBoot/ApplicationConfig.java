package com.DevCourses.SpringBoot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
    /*
    Thanks to this annotation, Spring will scan this class as soon as the application starts.
     */

public class ApplicationConfig {

    /* Notes:
     * - Default Bean name = Method name
     * - Using @Bean annotation with a name parameter to change the default name.
     * */

    @Bean(name = "myBean") // Also: @Bean("myBean")
    @Qualifier("Bean1")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First Bean");
    }

    @Bean
    /*
    @Qualifier("Bean2") When it's necessary to use this bean we can use @Qualifier with the bean name as a parameter.
                        Example: Go to file: MyFirstService.java:21:13 .
     */
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second Bean");
    }

    @Bean
    @Primary /* Higher priority Bean */
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Bean");
    }

}
