package com.DevCourses.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    // Profile Specific Config Files
    // The value of a property that may have been overwritten depending on the active profiles is assigned
    @Value("${messages.start.welcome}")
    private String welcomeMessage;

    // Profile Annotation on Components
    // Two components have been declared that are only loaded when the profile specified for each of them is activated
    private final DataSourceConfig dataSource;

    // Constructor
    @Autowired
    public FirstService(DataSourceConfig dataSource) {
        this.dataSource = dataSource;
    }

    // Getter Methods
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    // Other Method
    public String infoDataSource() {
        return dataSource.getDataSource();
    }

}
