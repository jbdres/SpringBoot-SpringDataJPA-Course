package com.DevCourses.SpringBoot.service.mapper;

import com.DevCourses.SpringBoot.dto.requests.StudentProfileRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentProfileResponseDto;
import com.DevCourses.SpringBoot.entity.Student;
import com.DevCourses.SpringBoot.entity.StudentProfile;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileMapper {

    public StudentProfile toEntity(StudentProfileRequestDto studentProfileRequestDto) {
        Student student = new Student();
        student.setId(studentProfileRequestDto.studentId());
        return new StudentProfile(
                studentProfileRequestDto.date(),
                studentProfileRequestDto.description(),
                student
        );
    }

    public StudentProfileResponseDto toResponse(StudentProfile studentProfile) {
        return new StudentProfileResponseDto(
                studentProfile.getDate(),
                studentProfile.getDescription()
        );
    }

}
