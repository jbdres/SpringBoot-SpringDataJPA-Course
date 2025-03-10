package com.DevCourses.SpringBoot.dto.responses;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email,
        int age
) {
}
