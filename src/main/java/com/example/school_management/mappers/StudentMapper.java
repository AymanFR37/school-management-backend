package com.example.school_management.mappers;

import com.example.school_management.dtos.StudentDto;
import com.example.school_management.entities.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface StudentMapper {

    StudentDto mapToDto(StudentEntity studentEntity);

    StudentEntity mapToEntity(StudentDto studentDto);
}
