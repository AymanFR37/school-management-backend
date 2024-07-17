package com.example.school_management.controllers;

import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.SectionEntity;
import com.example.school_management.services.section.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sections")
public class SectionController {
    private final SectionService sectionService;
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("all")
    public ResponseEntity<List<SectionDto>> getAll(){
        List<SectionDto> allSections = sectionService.getAllSections();
        return  ResponseEntity.ok(allSections);
    }

    @PostMapping("/add")
    public ResponseEntity<SectionDto> add(@RequestBody SectionDto section){
        return ResponseEntity.ok(sectionService.createSection(section));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SectionEntity> update(@PathVariable UUID id, @RequestBody SectionEntity section){
        SectionEntity updateClass = sectionService.updateSection(id, section);
        return ResponseEntity.ok(updateClass);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        sectionService.deleteSectionById(id);
        return ResponseEntity.noContent().build();
    }
}
