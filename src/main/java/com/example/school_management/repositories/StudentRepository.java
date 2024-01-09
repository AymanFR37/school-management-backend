package com.example.school_management.repositories;

import com.example.school_management.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    StudentEntity getStudentById(Long id);
}
