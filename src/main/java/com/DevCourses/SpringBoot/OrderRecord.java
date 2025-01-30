package com.DevCourses.SpringBoot;

/* Notes:
- Java Records are a powerful new feature introduced in Java 14 (and finalized in Java 16)
  that significantly simplifies the creation of immutable data classes. They address the verbosity
  and boilerplate code often associated with traditional Java classes used to represent data.
  * Immutable Data Carriers: Records are classes designed to hold immutable data. This means that once a record object is created,
    its values cannot be changed.
  * Automatic Code Generation: The key benefit of records is that the compiler automatically generates essential methods like
    constructors, getters, equals(), hashCode(), and toString(). This drastically reduces the amount of code you need to write.
  * Concise Syntax: Records have a very compact and readable syntax, making it easier to define data-centric classes.

- They are ideal for representing DTOs (Data Transfer Objects), API responses, data structures,
  and other scenarios where information only needs to be stored without modification.

- Java Records generally have better performance than POJOs in certain scenarios due to their immutability and reduced
  memory footprint. Here's why:
    * Memory Efficiency
        Faster equals(), hashCode() and toString(). These methods are auto-generated
        and optimized by the compiler.
    * Immutable = Thread Safe. Since records are immutable, they are naturally thread-safe without requiring
        synchronization which avoids the overhead of locks.
 */

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
