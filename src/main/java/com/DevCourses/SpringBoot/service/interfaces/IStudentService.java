package com.DevCourses.SpringBoot.service.interfaces;

import com.DevCourses.SpringBoot.dto.requests.StudentRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentResponseDto;

import java.util.List;

public interface IStudentService {

    public List<StudentResponseDto> getAll();

    public StudentResponseDto getById(Integer id);

    public StudentResponseDto create(StudentRequestDto studentRequestDto);

    public StudentResponseDto updateById(Integer id, StudentRequestDto studentRequestDto);

    public void deleteById(Integer id);

}
