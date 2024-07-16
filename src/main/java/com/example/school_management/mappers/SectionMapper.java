package com.example.school_management.mappers;

import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.SectionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface SectionMapper {
    SectionDto mapToDTO(SectionEntity sectionEntity);

    SectionEntity mapToEntity(SectionDto sectionDto);

    List<SectionDto> mapToDTOs(List<SectionEntity> all);
}
