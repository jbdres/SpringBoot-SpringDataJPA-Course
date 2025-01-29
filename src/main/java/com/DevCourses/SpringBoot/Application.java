package com.DevCourses.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        var ctx = SpringApplication.run(Application.class, args);

        FirstService firstService = ctx.getBean(FirstService.class);
        System.out.println(firstService.getWelcomeMessage());
        System.out.println(firstService.infoDataSource());

        /* Ways to specify the profiles | Resources: https://www.youtube.com/watch?v=feEM2dGEcVA
        - Via Maven
        - Via Environment Variable
        - Using a Jar
        - NOT in Profile Declarations
        - Profile Annotation on Class
        - Profile Annotation on Components
        - Profile Specific Config Files
         */

        /* Priority in Configuration Files
        Spring follows a resolution hierarchy to determine which configuration to use:
        1. Properties defined in the commands line
        2. Operative System environment variables
        3. Profile-specific properties files (application-{profile}.properties)
        4. Generic properties file (application.properties)

        This hierarchy means that if a property is defined in multiple places, Spring will use the value
        from the source with the highest priority. This allows for flexible configuration management,
        where you can have default values in application.properties, override them with profile-specific
        settings, and make further adjustments using environment variables or command-line arguments.
         */


    }

}
