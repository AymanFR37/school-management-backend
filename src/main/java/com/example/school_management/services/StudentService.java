package com.example.school_management.services;

import com.example.school_management.entities.StudentEntity;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentEntity addStudent(StudentEntity student);
    List<StudentEntity> getAll();
    StudentEntity updateStudent(UUID id, StudentEntity student);
    void deleteStudentById(UUID id);
    StudentEntity getStudentById(UUID id);
}
