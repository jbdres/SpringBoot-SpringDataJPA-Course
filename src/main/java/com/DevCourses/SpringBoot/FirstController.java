package com.DevCourses.SpringBoot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dev/api/student")
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository) { // Implicit Constructor Injection
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String studentName) {
        return repository.findAllByFirstnameContains(studentName);
    }

    @PostMapping("/")
    public Student postStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public Student putStudent(@PathVariable Integer id, @RequestBody Student student) {
        student.setId(id);
        return repository.save(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
