package com.DevCourses.SpringBoot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    /*
     @Autowired
     @Qualifier("Bean1")
     private MyFirstClass myFirstClass;
         Note: It's always recommended to use Constructor injection or Setter injection over Field injection
    */

    private final MyFirstClass myFirstClass;

    // Implicit Constructor Injection (@Autowired isn't used) | This is the best way to inject dependencies
    public MyFirstService(
            @Qualifier("mySecondBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    /*
     * Notes:
     * - Autowired annotation is not required for constructor injection.
     * - Spring automatically detects and injects dependencies through the constructor if there's
     *   only one constructor in the class. This is known as implicit constructor injection.
     * - Explicit Constructor Injection: If there are multiple constructors. You can use the
     *   @Autowired annotation to specify which constructor should be used for dependency injection.
     */

    /*
     Method Injection
     @Autowired
     public void injectDependencies(@Qualifier(value = "Bean1") MyFirstClass myFirstClass) {
         this.myFirstClass = myFirstClass;
     }

     Setter Injection
     @Autowired
     public void setMyFirstClass(MyFirstClass myFirstClass) { // Primary bean
         this.myFirstClass = myFirstClass;
     }
    */

    // Methods
    public String tellAStory() {
        return "The dependency (MyFirstClass) is saying: " + myFirstClass.sayHello();
    }

}
