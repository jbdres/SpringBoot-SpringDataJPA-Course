package com.DevCourses.SpringBoot.repository;

import com.DevCourses.SpringBoot.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISchoolRepository extends JpaRepository<School, Integer> {
}
