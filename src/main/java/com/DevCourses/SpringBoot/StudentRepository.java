package com.DevCourses.SpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    /* Query Methods Derivation:
     * - Is a feature of Spring data JPA that allows you to define query
     *   methods in a repository interface without writing explicit SQL
     *   or JPQL queries. Instead, Spring derives the query automatically
     *   based on the method name.
     * - How it works? Spring Data JPA analyzes the method name and
     *   translates it into a query based on the entity's field name.
     * */

    List<Student> findAllByFirstnameContains(String firstname);

    /* - The @Query annotation in Spring Data JPA allows you to define
         custom JPQL (Java Persistence Query Language) or native SQL queries
         directly in repository methods. It is useful when query method derivation
         is not enough for complex queries.
    * e.g.,
    * @Modifying
      @Transactional
      @Query(value = "INSERT INTO student (name, email, age) VALUES (:name, :email, :age)", nativeQuery = true)
      int insertStudent(@Param("name") String name, @Param("email") String email, @Param("age") int age);
    * */

}
