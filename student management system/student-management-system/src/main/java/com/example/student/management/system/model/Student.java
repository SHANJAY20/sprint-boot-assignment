package com.example.student.management.system.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "studentdb")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Firstname is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "User name must contain only letters")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "User name must contain only letters")
    private String lastname;
    @NotEmpty(message = "the email is required")
    @Email(message = "emailshould valid")
    private String email;
    @NotNull(message = "required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @NotNull(message = "required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollment;
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    private double gpa;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(LocalDate enrollment) {
        this.enrollment = enrollment;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student(int id, String firstname, String lastname, String email, LocalDate dob, LocalDate enrollment, double gpa) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.enrollment = enrollment;
        this.gpa = gpa;
    }

    public Student() {
    }
}
