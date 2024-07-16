package com.example.school_management.services;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;
import com.example.school_management.mappers.ClassMapper;
import com.example.school_management.repositories.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService{
    protected ClassMapper classMapper;
    private final ClassRepository classRepository;

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
    public ClassEntity updateClass(UUID UUID, ClassEntity classe) {
        return null;
    }

    @Override
    public void deleteClassById(UUID id) {
        classRepository.deleteById(id);
    }

    @Override
    public ClassDto getClassById(UUID id) {
        return classMapper.mapToDTO(classRepository.getClassEntityById(id));
    }
}
