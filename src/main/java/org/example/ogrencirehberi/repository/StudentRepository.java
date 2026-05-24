package org.example.ogrencirehberi.repository;

import org.example.ogrencirehberi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByDepartment(String department);
    boolean existsByStudentNumber(String studentNumber);
}