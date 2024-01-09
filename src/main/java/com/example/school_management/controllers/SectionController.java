package com.example.school_management.controllers;

import com.example.school_management.dtos.SectionDto;
import com.example.school_management.entities.SectionEntity;
import com.example.school_management.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<SectionEntity> update(@PathVariable int id,@RequestBody SectionEntity section){
        SectionEntity updateClass = sectionService.updateSection(id, section);
        return ResponseEntity.ok(updateClass);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        sectionService.deleteSectionById(id);
        return ResponseEntity.noContent().build();
    }
}
