package com.DevCourses.SpringBoot.service.mapper;

import com.DevCourses.SpringBoot.dto.requests.SchoolRequestDto;
import com.DevCourses.SpringBoot.dto.responses.SchoolResponseDto;
import com.DevCourses.SpringBoot.entity.School;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SchoolMapper {

    private final StudentMapper studentMapper;

    public SchoolMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public School toEntity(SchoolRequestDto schoolRequestDto) {
        return new School(
                schoolRequestDto.name(),
                schoolRequestDto.address(),
                schoolRequestDto.phone()
        );
    }

    public SchoolResponseDto toResponse(School school) {
        return new SchoolResponseDto(
                school.getName(),
                school.getAddress(),
                school.getPhone()
        );
    }

}
