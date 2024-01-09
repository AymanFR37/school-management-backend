package com.example.school_management.mappers;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ClassMapper {
    ClassDto mapToDTO(ClassEntity classEntity);

    ClassEntity mapToEntity(ClassDto classDto);

    List<ClassDto> mapToDTOs(List<ClassEntity> all);
}
