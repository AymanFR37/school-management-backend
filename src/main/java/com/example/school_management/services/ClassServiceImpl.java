package com.example.school_management.services;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;
import com.example.school_management.mappers.ClassMapper;
import com.example.school_management.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    protected ClassMapper classMapper;
    private final ClassRepository classRepository;
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Transactional
    @Override
    public List<ClassDto> getAllClasses() {
        return classMapper.mapToDTOs(classRepository.findAll());
    }

    @Override
    public ClassDto createClass(ClassDto classe) {
        return classMapper.mapToDTO(classRepository.save(classMapper.mapToEntity(classe)));
    }

    @Override
    public ClassEntity updateClass(int id, ClassEntity classe) {
        return null;
    }

    @Override
    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }

    @Override
    public ClassDto getClassById(Long id) {
        return classMapper.mapToDTO(classRepository.getClassEntityById(id));
    }
}
