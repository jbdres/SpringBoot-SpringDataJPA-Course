package com.DevCourses.SpringBoot.repository;

import com.DevCourses.SpringBoot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
