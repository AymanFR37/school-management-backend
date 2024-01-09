package com.example.school_management.services;

import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.SectionEntity;

import java.util.List;

public interface SectionService {
    List<SectionDto> getAllSections();

    SectionDto createSection(SectionDto section);

    SectionEntity updateSection(int id, SectionEntity section);

    void deleteSectionById(Long id);
}
