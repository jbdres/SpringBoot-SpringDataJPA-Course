package com.DevCourses.SpringBoot.service.implementation;

import com.DevCourses.SpringBoot.dto.requests.StudentRequestDto;
import com.DevCourses.SpringBoot.dto.responses.StudentResponseDto;
import com.DevCourses.SpringBoot.model.Student;
import com.DevCourses.SpringBoot.repository.IStudentRepository;
import com.DevCourses.SpringBoot.service.mapper.StudentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceImpTest {

    // The service that we want to test
    @InjectMocks
    private StudentServiceImp studentServiceImp;
    // Declare dependencies
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Necessary
    /*
    - StudentRequestDto
    - Student
    - StudentResponseDto
    * */

    @Test
    public void should_successfully_save_a_student() {

        // Important terms: Isolation and mock

        // Objects
        StudentRequestDto studentRequestDto = new StudentRequestDto(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20,
                1
        );
        Student student = new Student(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        );
        Student savedStudent = new Student(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        );
        savedStudent.setId(1);
        StudentResponseDto studentResponseDto = new StudentResponseDto(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        );

        // Mock the calls
        // We need to mock every call that uses another dependency in studentServiceImp
        // Way: The argument and the return value in the methods that we use in studentServiceImp.create():
        when(studentMapper.toEntity(studentRequestDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toResponse(student)).thenReturn(studentResponseDto);

        // When
        StudentResponseDto finalStudentResponseDto = studentServiceImp.create(studentRequestDto);

        // Then
        assertEquals(studentRequestDto.firstname(), finalStudentResponseDto.firstname());
        assertEquals(studentRequestDto.lastname(), finalStudentResponseDto.lastname());
        assertEquals(studentRequestDto.age(), finalStudentResponseDto.age());

        // How many times can we call those methods? No more than one time.
        verify(studentMapper, times(1)).toEntity(studentRequestDto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toResponse(savedStudent);

    }

    @Test
    public void should_return_all_students() {
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        ));

        // Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toResponse(any(Student.class))).thenReturn(new StudentResponseDto(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        ));

        List<StudentResponseDto> responseDtos = studentServiceImp.getAll();
        assertEquals(students.size(), responseDtos.size());

        verify(studentRepository, times(1)).findAll();

    }

    @Test
    public void should_return_all_students_by_id() {
        Integer studentId = 1;
        Student student = new Student(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        );
        // Mock the calls
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        when(studentMapper.toResponse(any(Student.class))).thenReturn(new StudentResponseDto(
                "Julian",
                "Bermudez",
                "jbdres@mail.com",
                20
        ));

        StudentResponseDto studentResponseDto = studentServiceImp.getById(studentId);

        assertEquals(student.getFirstname(), studentResponseDto.firstname());
        assertEquals(student.getLastname(), studentResponseDto.lastname());
        assertEquals(student.getEmail(), studentResponseDto.email());

        verify(studentRepository, times(1)).findById(studentId);

    }

}