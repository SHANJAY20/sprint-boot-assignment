package com.example.student.management.system.service;

import com.example.student.management.system.model.Student;
import com.example.student.management.system.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo sturepo;
    public Student createStudent(Student student) {
        Student st=new Student();
        st.setDob(student.getDob());
        st.setEmail(student.getEmail());
        st.setFirstname(student.getFirstname());
        st.setLastname(student.getLastname());
        st.setEnrollment(student.getEnrollment());
        st.setGpa(student.getGpa());
        sturepo.save(st);
        return st;
    }

    public Optional<Student> showStudent(int id) {
        return sturepo.findById(id);
    }

    public String deleteStudent(int id) {
        Optional<Student> st=sturepo.findById(id);
        if(st.isPresent()) {
            sturepo.deleteById(id);
            return "deleted";
        }
        else return "not found";
    }

    public Student saveStudent(Student existingStudent) {
        sturepo.save(existingStudent);
        return existingStudent;
    }
}
