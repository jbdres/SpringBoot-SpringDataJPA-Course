package com.DevCourses.SpringBoot.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentRequestDto(

        /* Notes:
        - All the annotations that we can use to validate attributes are in the jakarta.validation.constraints package.
        - For the Email annotations, we can use custom regular expressions to validate the email format, with regexp() method.
         */

        @NotEmpty(message = "First name is required")
        String firstname,
        @NotEmpty
        String lastname,
        @Email(message = "Email should be valid")
        String email,
        int age,
        Integer schoolId
) {
}
