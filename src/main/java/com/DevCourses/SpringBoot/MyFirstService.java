package com.DevCourses.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    /*
    Environment Bean: It's a Bean that help us to read some environment, system and application
    properties, even reading the command line arguments.
     */
    private Environment environment;

    @Autowired // Inject the Environment Bean (Setter Injection)
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    // Methods
    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOSName() {
        return environment.getProperty("os.name");
    }

    public String getApplicationProperty() {
        return environment.getProperty("myCustomProperty");
    }

}
