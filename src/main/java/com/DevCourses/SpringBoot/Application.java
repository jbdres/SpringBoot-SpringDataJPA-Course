package com.DevCourses.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        /* Spring REST
        Is an architectural style for designing web services. It provides a standardized
        way for systems to communicate over HTTP by using a set of principles rather
        than a strict protocol. RESTful APIs (Application Programming Interfaces) follow
        these principles to enable interoperability between different systems.

        Key Principles of REST:
        1. Statelessness: Each request from a client to a server must contain all the
           necessary information. The server don't store client session data.
        2. Client-Server Architecture: The client and server are independent. The client
           only request resources, the server provides them.
        3. Uniform Interface: REST API should follow a consistent structure, typically
           using standard HTTP methods: GET, POST, PUT, DELETE.
        4. Resource-Based: Everything in REST is treated as a resource, identify by an
           unique URL (e.g., /users/123 to access user 123).
        5. Stateless Communication: Each request is processed independently; no client
           state is stored on the server.
        6. Cache ability - Responses should be explicitly defined as cacheable or
           non-cacheable to optimize performance.
        7. Layered System - a REST API can have multiple layers (e.g., security, load balancing)
           without affecting the client-server interaction.

        HTTP Responses: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
        - 1XX Informational, 2XX Success, 3XX Redirection, 4XX Client Error, 5XX Server Error

         */

        SpringApplication.run(Application.class, args);
        // Testing Java Records
        OrderRecord orderRecord = new OrderRecord("Julian", "Car", 1);
        System.out.println("This is the product: " + orderRecord.productName());

    }

}
