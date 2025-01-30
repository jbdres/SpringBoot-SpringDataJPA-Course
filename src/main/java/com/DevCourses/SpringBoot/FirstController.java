package com.DevCourses.SpringBoot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dev/api")
public class FirstController {

    /* This method creates a conflict because there is already another http method pointing to the same path.
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }
    */

    // Request Body
    // e.g., Text Format: Hello World
    @PostMapping("/post-string")
    public String postMessage(@RequestBody String message) {
        return "This is my post message: " + message;
    }

    // Request Body | POJO (Plain Old Java Object)
    /* e.g., JSON Format
    {
        "c-name":"Julian",
        "productName":"laptop",
        "quantity":5
    }
    */
    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order) {
        return "This is my post order: " + order.toString();
    }

    // Request Body with a Record Object
    @PostMapping("/post-order-record")
    public String postOrderRecord(@RequestBody OrderRecord orderRecord) {
        return "This is my post order record: " + orderRecord.toString();
    }

    // Path Variable | Any HTTP request
    // e.g., http://localhost:8080/hello/friends/2
    @GetMapping("/resources/{user-list}/{page}")
    public String pathVar(
            @PathVariable("user-list") String userList,
            @PathVariable int page
    ) {
        return "My list = " + userList + " | page = " + page;
    }

    // Request Mapping | Any HTTP request
    // e.g., http://localhost:8080/hello?firstParam=firstValue&secondParam=secondValue
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam String userLastname
    ) {
        return "Hello my name is = " + userName + " and my  lastname = " + userLastname;
    }

}
