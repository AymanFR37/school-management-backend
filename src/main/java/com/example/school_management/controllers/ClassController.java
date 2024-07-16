package com.example.school_management.controllers;

import com.example.school_management.dtos.ClassDto;
import com.example.school_management.entities.ClassEntity;
import com.example.school_management.services.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("all")
    public ResponseEntity<List<ClassDto>> getAll(){
        List<ClassDto> allClasses = classService.getAllClasses();
        return  ResponseEntity.ok(allClasses);
    }

    @PostMapping("/add")
    public ResponseEntity<ClassDto> add(@RequestBody ClassDto classe){
        ClassDto aClass = classService.createClass(classe);
        return new ResponseEntity<>(aClass, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClassEntity> update(@PathVariable UUID id, @RequestBody ClassEntity classe){
        ClassEntity updateClass = classService.updateClass(id, classe);
        return ResponseEntity.ok(updateClass);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        classService.deleteClassById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(classService.getClassById(id));
    }
}
