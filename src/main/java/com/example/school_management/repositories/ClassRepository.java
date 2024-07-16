package com.example.school_management.repositories;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassRepository extends JpaRepository<ClassEntity, UUID> {
    ClassEntity getClassEntityByName(String name);

    ClassEntity getClassEntityById(UUID id);
}
