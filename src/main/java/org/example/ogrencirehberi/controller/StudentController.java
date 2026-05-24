package org.example.ogrencirehberi.controller;

import jakarta.validation.Valid;
import org.example.ogrencirehberi.dto.StudentRequest;
import org.example.ogrencirehberi.model.Student;
import org.example.ogrencirehberi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Derived Query Method için yeni endpoint
    @GetMapping("/department/{department}")
    public List<Student> getStudentsByDepartment(@PathVariable String department) {
        return studentService.getStudentsByDepartment(department);
    }

    // @Valid anotasyonu ile DTO doğrulaması devreye giriyor
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Öğrenci başarıyla silindi! ID: " + id);
    }
}