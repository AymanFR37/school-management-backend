package com.example.school_management.repositories;

import com.example.school_management.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    StudentEntity getStudentById(UUID id);
}
