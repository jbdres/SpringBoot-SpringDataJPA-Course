package com.DevCourses.SpringBoot.service.interfaces;

import com.DevCourses.SpringBoot.dto.requests.SchoolRequestDto;
import com.DevCourses.SpringBoot.dto.responses.SchoolResponseDto;

import java.util.List;

public interface ISchoolService {

    public List<SchoolResponseDto> getAll();

    public SchoolResponseDto getById(Integer id);

    public SchoolResponseDto create(SchoolRequestDto schoolRequestDto);

    public SchoolResponseDto updateById(Integer id, SchoolRequestDto schoolRequestDto);

    public void deleteById(Integer id);

}
