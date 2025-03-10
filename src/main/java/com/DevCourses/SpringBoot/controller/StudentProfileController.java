package com.DevCourses.SpringBoot.controller;

import com.DevCourses.SpringBoot.dto.requests.StudentProfileRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentProfileResponseDto;
import com.DevCourses.SpringBoot.service.implementation.StudentProfileServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentProfiles")
public class StudentProfileController {

    private final StudentProfileServiceImp studentProfileServiceImp;

    public StudentProfileController(StudentProfileServiceImp studentProfileServiceImp) {
        this.studentProfileServiceImp = studentProfileServiceImp;
    }

    @GetMapping("/")
    public List<StudentProfileResponseDto> getAllStudentProfiles() {
        return studentProfileServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public StudentProfileResponseDto getStudentProfileById(@PathVariable Integer id) {
        return studentProfileServiceImp.getById(id);
    }

    @PostMapping("/")
    public StudentProfileResponseDto createStudentProfile(@RequestBody StudentProfileRequestDto studentProfileRequestDto) {
        return studentProfileServiceImp.create(studentProfileRequestDto);
    }

    @PutMapping("/{id}")
    public StudentProfileResponseDto updateStudentProfile(@PathVariable Integer id, @RequestBody StudentProfileRequestDto studentProfileRequestDto) {
        return studentProfileServiceImp.updateById(id, studentProfileRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentProfileById(@PathVariable Integer id) {
        studentProfileServiceImp.deleteById(id);
    }

}
