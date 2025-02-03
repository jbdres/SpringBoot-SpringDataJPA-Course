package com.DevCourses.SpringBoot;

import jakarta.persistence.*;

@Entity
// @Table(name = "table_student")
public class Student {

    /* Note:
     * -  @GeneratedValue annotation is used to specify how the primary
     *    key (ID) of an entity should be generated.
     *    - It is placed above a field (usually the primary key) to indicate
     *      that its value should be automatically generated.
     *    GenerationType (Which use?):
     *       - IDENTITY: MySQL or any database with AUTO_INCREMENT.
     *       - SEQUENCE: PostgreSQL or ORACLE (support better performance with
     *                   batch inserts).
     *       - AUTO: If unsure, let JPA decide.
     *       - TABLE: Only if the database does not support sequences or
     *                auto-increment (not recommended due to performance issues).
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /* Note:
    * - With the @Column annotation we can set the next properties of a field:
    *   name, unique, nullable, insertable, updatable, columnDefinition,
    *   table, length, precision, scale.
    *   ------------------------------
    *   e.g., @Column(
                insertable = false,
                updatable = false
        )
        private String someColumn
    *   ------------------------------
    * */

    @Column(
            name = "c_firstname",
            length = 30
    )
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;

    // Specifies the one-to-one relationship between two entities
    @OneToOne(

            /* mappedBy="student"
            - This indicates that the StudentProfile entity is the owning side of the relationship.
               The Student entity is the inverse side.
            - The mappedBy attribute tells JPA that the foreign key is managed by the student field
              int the StudentProfile entity.
             */

            /* cascade = CascadeType.ALL
            - Any operation (e.g., save, update, delete) performed on the Student entity will also
              be applied to the associated StudentProfile entity. For example, if you delete a
              Student, the associated StudentProfile will also be deleted.
             */

            mappedBy = "student",
            cascade = CascadeType.ALL

    )
    private StudentProfile studentProfile;
    // - studentProfile: This is the reference to the StudentProfile entity in the Student entity

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;


    /* The empty constructor (no-argument constructor)
     * - JPA requires it: Hibernate (the Default JPA provider in Spring Boot) uses reflection to instantiate
     *   entity objects. Without a no-argument constructor, Hibernate won't be able to create instances of the entity.
     * - Proxying mechanism: Hibernate creates proxy objects for lazy loading, and for this, it needs to be able to
     *   instantiate the entity without arguments.
     * */
    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
