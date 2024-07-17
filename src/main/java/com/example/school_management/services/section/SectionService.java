package com.example.school_management.services.section;

import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.SectionEntity;

import java.util.List;
import java.util.UUID;

public interface SectionService {
    List<SectionDto> getAllSections();

    SectionDto createSection(SectionDto section);

    SectionEntity updateSection(UUID id, SectionEntity section);

    void deleteSectionById(UUID id);
}
