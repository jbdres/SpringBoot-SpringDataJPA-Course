package com.DevCourses.SpringBoot.controller;

import com.DevCourses.SpringBoot.dto.requests.SchoolRequestDto;
import com.DevCourses.SpringBoot.dto.responses.SchoolResponseDto;
import com.DevCourses.SpringBoot.service.implementation.SchoolServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolServiceImp schoolServiceImp;

    public SchoolController(SchoolServiceImp schoolServiceImp) {
        this.schoolServiceImp = schoolServiceImp;
    }


    @GetMapping("/")
    public List<SchoolResponseDto> getAllSchools() {
        return schoolServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public SchoolResponseDto getSchoolById(@PathVariable Integer id) {
        return schoolServiceImp.getById(id);
    }

    @PostMapping("/")
    public SchoolResponseDto createSchool(@RequestBody SchoolRequestDto schoolRequestDto) {
        return schoolServiceImp.create(schoolRequestDto);
    }

    @PutMapping("/{id}")
    public SchoolResponseDto updateSchool(@PathVariable Integer id, @RequestBody SchoolRequestDto schoolRequestDto) {
        return schoolServiceImp.updateById(id, schoolRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSchoolById(@PathVariable Integer id) {
        schoolServiceImp.deleteById(id);
    }

}
