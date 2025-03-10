package com.DevCourses.SpringBoot.dto.requests;

public record StudentProfileRequestDto(
        String date,
        String description,
        Integer studentId
) {
}
