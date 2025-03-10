package com.DevCourses.SpringBoot.service.implementation;

import com.DevCourses.SpringBoot.dto.requests.StudentRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentResponseDto;
import com.DevCourses.SpringBoot.model.School;
import com.DevCourses.SpringBoot.model.Student;
import com.DevCourses.SpringBoot.repository.ISchoolRepository;
import com.DevCourses.SpringBoot.repository.IStudentRepository;
import com.DevCourses.SpringBoot.service.interfaces.IStudentService;
import com.DevCourses.SpringBoot.service.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements IStudentService {

    public final StudentMapper studentMapper;
    public final IStudentRepository studentRepository;
    public final ISchoolRepository schoolRepository;

    public StudentServiceImp(StudentMapper studentMapper, IStudentRepository studentRepository, ISchoolRepository schoolRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<StudentResponseDto> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto getById(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::toResponse)
                .orElse(null);
    }

    @Override
    public StudentResponseDto create(StudentRequestDto studentRequestDto) {
        return studentMapper.toResponse(
                studentRepository.save(
                        studentMapper.toEntity(studentRequestDto)
                )
        );
    }

    @Override
    public StudentResponseDto updateById(Integer id, StudentRequestDto studentRequestDto) {
        Student actualStudent = studentRepository.findById(id).orElse(null);
        School actualSchool = schoolRepository.findById(studentRequestDto.schoolId()).orElse(null);
        if (actualStudent == null || actualSchool == null) {
            return null;
        }
        actualStudent.setFirstname(studentRequestDto.firstname());
        actualStudent.setLastname(studentRequestDto.lastname());
        actualStudent.setEmail(studentRequestDto.email());
        actualStudent.setSchool(actualSchool);

        return studentMapper.toResponse(studentRepository.save(actualStudent));

    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

}
