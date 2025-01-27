package com.DevCourses.SpringBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

/* Notes:
 - Two .properties files different from application.properties have been created, where the data will be used as values for the class attributes.
 - If only the properties of one of the created files were used, it would be:
 @PropertySource("classpath:laptop.properties")
 */

@Service
@PropertySources({
        @PropertySource("classpath:laptop.properties"),
        @PropertySource("classpath:phone.properties")
})
public class MyFirstService {

    // Attributes
    // Default values
    @Value("Colombia")
    private String country;
    @Value("2025")
    private int year;

    // From application.properties file
    @Value("${developer.github.profile}")
    private String profile;
    @Value("${developer.age}")
    private int age;

    // From laptop.properties file
    @Value("${laptop.specs.manufacter}")
    private String laptopManufacter;
    @Value("${laptop.specs.model}")
    private String laptopModel;
    @Value("${laptop.specs.processor}")
    private String laptopProcessor;
    @Value("${laptop.specs.installedRAM}")
    private double laptopInstalledRAM;
    @Value("${laptop.specs.system.type}")
    private String laptopSystemType;

    // From phone.properties file
    @Value("${phone.specs.manufacter}")
    private String phoneManufacter;
    @Value("${phone.specs.model}")
    private String phoneModel;
    @Value("${phone.specs.camera.resolution}")
    private String phoneCameraResolution;
    @Value("${phone.specs.so.version}")
    private String phoneSoVersion;

    // Getter Methods
    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getProfile() {
        return profile;
    }

    public int getAge() {
        return age;
    }

    public String getLaptopManufacter() {
        return laptopManufacter;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public String getLaptopProcessor() {
        return laptopProcessor;
    }

    public double getLaptopInstalledRAM() {
        return laptopInstalledRAM;
    }

    public String getLaptopSystemType() {
        return laptopSystemType;
    }

    public String getPhoneManufacter() {
        return phoneManufacter;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public String getPhoneCameraResolution() {
        return phoneCameraResolution;
    }

    public String getPhoneSoVersion() {
        return phoneSoVersion;
    }

}
