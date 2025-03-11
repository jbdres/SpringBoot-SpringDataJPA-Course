package com.DevCourses.SpringBoot.controller;

import com.DevCourses.SpringBoot.dto.requests.StudentRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentResponseDto;
import com.DevCourses.SpringBoot.service.implementation.StudentServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImp studentServiceImp;

    public StudentController(StudentServiceImp studentServiceImp) {
        this.studentServiceImp = studentServiceImp;
    }

    @GetMapping("/")
    public List<StudentResponseDto> getAllStudents() {
        return studentServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Integer id) {
        return studentServiceImp.getById(id);
    }

    @PostMapping("/")
    public StudentResponseDto createStudent(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        return studentServiceImp.create(studentRequestDto);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Integer id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentServiceImp.updateById(id, studentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentServiceImp.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        HashMap<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
