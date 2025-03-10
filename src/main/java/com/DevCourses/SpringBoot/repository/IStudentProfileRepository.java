package com.DevCourses.SpringBoot.repository;

import com.DevCourses.SpringBoot.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentProfileRepository extends JpaRepository<StudentProfile, Integer> {
}
