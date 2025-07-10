package com.example.student.management.system.repository;

import com.example.student.management.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepo extends JpaRepository<Student,Integer>{
}
