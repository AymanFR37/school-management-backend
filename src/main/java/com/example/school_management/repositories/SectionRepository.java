package com.example.school_management.repositories;

import com.example.school_management.entities.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<SectionEntity,Long> {
}
