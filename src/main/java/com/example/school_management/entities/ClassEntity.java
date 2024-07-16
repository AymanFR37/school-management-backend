package com.example.school_management.entities;

import com.example.school_management.entities.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classes")
public class ClassEntity extends AbstractEntity {

    private String name;
    @OneToMany
    private List<StudentEntity> students;
    @OneToMany
    private List<SectionEntity> sections;
}
