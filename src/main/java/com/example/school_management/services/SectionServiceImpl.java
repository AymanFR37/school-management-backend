package com.example.school_management.services;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.ClassEntity;
import com.example.school_management.entities.SectionEntity;
import com.example.school_management.mappers.ClassMapper;
import com.example.school_management.mappers.SectionMapper;
import com.example.school_management.repositories.ClassRepository;
import com.example.school_management.repositories.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService{
    protected SectionMapper sectionMapper;
    protected ClassMapper classMapper;
    private final SectionRepository sectionRepository;
    private final ClassRepository classRepository;

    @Override
    public List<SectionDto> getAllSections() {
        return sectionMapper.mapToDTOs(sectionRepository.findAll());
    }

    @Transactional
    @Override
    public SectionDto createSection(SectionDto sectionDto) {

        ClassDto className = sectionDto.getClassEntity();
        System.out.println("className = " + className);

        ClassEntity classEntity = classRepository.getClassEntityByName(className.getName());
        System.out.println("classEntity = " + classEntity);
        if (classEntity != null) {
            sectionDto.setClassEntity(classMapper.mapToDTO(classEntity));
        } else {
            //Handle the case where the specified class does not exist
            System.out.println("ClassEntity with name " + className + " not found");
        }
        return sectionMapper.mapToDTO(sectionRepository.save(sectionMapper.mapToEntity(sectionDto)));
    }

    @Override
    public SectionEntity updateSection(UUID id, SectionEntity section) {
        return null;
    }

    @Override
    public void deleteSectionById(UUID id) {
        sectionRepository.deleteById(id);
    }
}
