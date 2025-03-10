package com.DevCourses.SpringBoot.service.implementation;

import com.DevCourses.SpringBoot.dto.requests.StudentProfileRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentProfileResponseDto;
import com.DevCourses.SpringBoot.model.Student;
import com.DevCourses.SpringBoot.model.StudentProfile;
import com.DevCourses.SpringBoot.repository.IStudentProfileRepository;
import com.DevCourses.SpringBoot.repository.IStudentRepository;
import com.DevCourses.SpringBoot.service.interfaces.IStudentProfileService;
import com.DevCourses.SpringBoot.service.mapper.StudentProfileMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentProfileServiceImp implements IStudentProfileService {

    private final StudentProfileMapper studentProfileMapper;
    private final IStudentProfileRepository studentProfileRepository;
    private final IStudentRepository studentRepository;

    public StudentProfileServiceImp(StudentProfileMapper studentProfileMapper, IStudentProfileRepository studentProfileRepository, IStudentRepository studentRepository) {
        this.studentProfileMapper = studentProfileMapper;
        this.studentProfileRepository = studentProfileRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentProfileResponseDto> getAll() {
        return studentProfileRepository.findAll()
                .stream()
                .map(studentProfileMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentProfileResponseDto getById(Integer id) {
        return studentProfileRepository.findById(id)
                .map(studentProfileMapper::toResponse)
                .orElse(null);
    }

    @Override
    public StudentProfileResponseDto create(StudentProfileRequestDto studentProfileRequestDto) {
        return studentProfileMapper.toResponse(
                studentProfileRepository.save(
                        studentProfileMapper.toEntity(studentProfileRequestDto)
                )
        );
    }

    @Override
    public StudentProfileResponseDto updateById(Integer id, StudentProfileRequestDto studentProfileRequestDto) {
        StudentProfile actualStudentProfile = studentProfileRepository.findById(id).orElse(null);
        Student actualStudent = studentRepository.findById(studentProfileRequestDto.studentId()).orElse(null);
        if (actualStudentProfile == null || actualStudent == null) {
            return null;
        }
        actualStudentProfile.setDate(studentProfileRequestDto.date());
        actualStudentProfile.setDescription(studentProfileRequestDto.description());
        actualStudentProfile.setStudent(actualStudent);
        return studentProfileMapper.toResponse(studentProfileRepository.save(actualStudentProfile));
    }

    @Override
    public void deleteById(Integer id) {
        studentProfileRepository.deleteById(id);
    }
}
