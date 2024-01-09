package com.example.school_management.services;

import com.example.school_management.entities.ClassEntity;
import com.example.school_management.entities.StudentEntity;
import com.example.school_management.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public ClassEntity getClassByStudentId(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId).orElse(null);
        if (student != null && student.getSection() != null) {
            return student.getSection().getClassEntity();
        }
        return null;
    }
}
