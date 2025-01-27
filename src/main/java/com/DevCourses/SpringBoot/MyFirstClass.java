package com.DevCourses.SpringBoot;

public class MyFirstClass {

    // Attribute
    private final String myVar;

    // Constructor
    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    // Method
    public String sayHello() {
        return "Hello from my first class | MyVar: " + myVar;
    }

}
