package com.DevCourses.SpringBoot.service.mapper;

import com.DevCourses.SpringBoot.dto.requests.StudentRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentResponseDto;
import com.DevCourses.SpringBoot.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentRequestDto dto = new StudentRequestDto(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20,
                1
        );
        Student student = studentMapper.toEntity(dto);

        assertEquals(student.getFirstname(), dto.firstname());
        assertEquals(student.getLastname(), dto.lastname());
        assertEquals(student.getEmail(), dto.email());
        // Validate that school is not null to access its methods
        assertNotNull(student.getSchool());
        assertEquals(student.getSchool().getId(), dto.schoolId());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        Student student = new Student(
                "Kevin",
                "Tovar",
                "kevin@mail.com",
                25
        );
        StudentResponseDto responseDto = studentMapper.toResponse(student);
        assertEquals(responseDto.firstname(), student.getFirstname());
        assertEquals(responseDto.lastname(), student.getLastname());
        assertEquals(responseDto.email(), student.getEmail());
        assertEquals(responseDto.age(), student.getAge());
    }

}