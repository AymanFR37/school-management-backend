package com.example.school_management.services;

import com.example.school_management.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity addStudent(StudentEntity student);
    List<StudentEntity> getAll();
    StudentEntity updateStudent(Long id, StudentEntity student);
    void deleteStudentById(Long id);
    StudentEntity getStudentById(Long id);
}
