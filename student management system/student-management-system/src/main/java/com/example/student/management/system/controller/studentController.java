package com.example.student.management.system.controller;

import com.example.student.management.system.model.Student;
import com.example.student.management.system.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class studentController {
    @Autowired
    private StudentService stuServ;
    @PostMapping("/post")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student){
        Student st=stuServ.createStudent(student);
        System.out.println("username"+st.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Student>> showStudent(@PathVariable int id){
        Optional<Student> st=stuServ.showStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(st);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        String result = stuServ.deleteStudent(id);
        if (result.equals("deleted")) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @Valid @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = stuServ.showStudent(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstname(studentDetails.getFirstname());
            existingStudent.setLastname(studentDetails.getLastname());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setDob(studentDetails.getDob());
            existingStudent.setEnrollment(studentDetails.getEnrollment());
            existingStudent.setGpa(studentDetails.getGpa());
            Student updatedStudent = stuServ.saveStudent(existingStudent);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + id);
        }
    }


}
