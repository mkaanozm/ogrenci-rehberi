package org.example.ogrencirehberi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequest {

    @NotBlank(message = "Öğrenci adı boş bırakılamaz")
    private String firstName;

    @NotBlank(message = "Öğrenci soyadı boş bırakılamaz")
    private String lastName;

    @NotBlank(message = "Öğrenci numarası boş bırakılamaz")
    @Size(min = 3, max = 10, message = "Öğrenci numarası 3 ile 10 karakter arasında olmalıdır")
    private String studentNumber;

    @NotBlank(message = "Bölüm boş bırakılamaz")
    private String department;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}