package com.example.school_management.mappers;

import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.SectionEntity;
import org.mapstruct.Mapper;

import java.util.List;

//@Mapper(config = MapStructConfig.class, uses = ClassMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Mapper(config = MapStructConfig.class)
public interface SectionMapper {
//    @Mapping(target = "classEntity", source = "classEntity.name")
    SectionDto mapToDTO(SectionEntity sectionEntity);

//    @Mapping(source = "classEntity", target = "classEntity.name")
    SectionEntity mapToEntity(SectionDto sectionDto);

    List<SectionDto> mapToDTOs(List<SectionEntity> all);
}
