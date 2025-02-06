package com.DevCourses.SpringBoot.service.interfaces;

import com.DevCourses.SpringBoot.dto.requests.StudentProfileRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentProfileResponseDto;

import java.util.List;

public interface IStudentProfileService {

    public List<StudentProfileResponseDto> getAll();

    public StudentProfileResponseDto getById(Integer id);

    public StudentProfileResponseDto create(StudentProfileRequestDto studentProfileRequestDto);

    public StudentProfileResponseDto updateById(Integer id, StudentProfileRequestDto studentProfileRequestDto);

    public void deleteById(Integer id);

}
