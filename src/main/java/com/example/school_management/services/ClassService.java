package com.example.school_management.services;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;

import java.util.List;
import java.util.UUID;

public interface ClassService {
    List<ClassDto> getAllClasses();

    ClassDto createClass(ClassDto classe);

    ClassEntity updateClass(UUID id, ClassEntity classe);

    void deleteClassById(UUID id);

    ClassDto getClassById(UUID id);
}
