package com.DevCourses.SpringBoot.dto.requests;

import jakarta.validation.constraints.NotEmpty;

public record StudentRequestDto(
        @NotEmpty
        String firstname,
        String lastname,
        String email,
        int age,
        Integer schoolId
) {
}
