package com.DevCourses.SpringBoot.service.mapper;

import com.DevCourses.SpringBoot.dto.requests.SchoolRequestDto;
import com.DevCourses.SpringBoot.dto.responses.SchoolResponseDto;
import com.DevCourses.SpringBoot.model.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

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
