package com.DevCourses.SpringBoot;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    // Specifies the one-to-one relationship between two entities
    @OneToOne
    @JoinColumn(name = "student_id")
        /*
        - This indicates that the StudentProfile table will have a foreign key column named student_id
          that references the primary key of the Student table. This makes StudentProfile the owning
          side of the relationship
         */
    private Student student;
    // This is the reference to the Student entity in the StudentProfile entity

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
