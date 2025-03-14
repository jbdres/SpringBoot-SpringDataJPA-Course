package com.DevCourses.SpringBoot.service.mapper;

import com.DevCourses.SpringBoot.dto.requests.StudentRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentResponseDto;
import com.DevCourses.SpringBoot.model.School;
import com.DevCourses.SpringBoot.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toEntity(StudentRequestDto studentDto) {

        if (studentDto == null) { throw new NullPointerException("studentDto is null"); }

        School school = new School();
        school.setId(studentDto.schoolId());
        return new Student(
                studentDto.firstname(),
                studentDto.lastname(),
                studentDto.email(),
                studentDto.age(),
                school
        );
    }

    public StudentResponseDto toResponse(Student student) {
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getAge()
        );
    }

}
