package org.example.ogrencirehberi.service;

import org.example.ogrencirehberi.dto.StudentRequest;
import org.example.ogrencirehberi.model.Student;
import org.example.ogrencirehberi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }


    @Transactional(rollbackFor = Exception.class)
    public Student createStudent(StudentRequest request) {


        if (studentRepository.existsByStudentNumber(request.getStudentNumber())) {
            throw new RuntimeException("Bu öğrenci numarası zaten sistemde kayıtlı!");
        }


        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setStudentNumber(request.getStudentNumber());
        student.setDepartment(request.getDepartment());

        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}