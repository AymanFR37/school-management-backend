package com.example.school_management.services;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;

import java.util.List;

public interface ClassService {
    List<ClassDto> getAllClasses();

    ClassDto createClass(ClassDto classe);

    ClassEntity updateClass(int id, ClassEntity classe);

    void deleteClassById(Long id);

    ClassDto getClassById(Long id);
}
