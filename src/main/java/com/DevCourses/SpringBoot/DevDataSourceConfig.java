package com.DevCourses.SpringBoot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

// Profile Annotation on Components
@Repository
@Profile("dev") // @Profile("!prod") Reverse profile
                // @Profile({"ved", "test"}) Use multiple profiles
public class DevDataSourceConfig implements DataSourceConfig {
    @Override
    public String getDataSource() {
        return "Configuring the development database";
    }
}
