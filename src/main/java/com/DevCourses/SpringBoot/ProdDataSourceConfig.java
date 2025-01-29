package com.DevCourses.SpringBoot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

// Profile Annotation on Components
@Repository
@Profile("prod") // @Profile("!dev") Reverse profile
                 // @Profile({"prod", "test"}) Use multiple profiles
public class ProdDataSourceConfig implements DataSourceConfig {
    @Override
    public String getDataSource() {
        return "Configuring the production database";
    }
}
