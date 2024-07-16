package com.example.school_management.entities;

import com.example.school_management.entities.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sections")
public class SectionEntity extends AbstractEntity {

    private String name;

    @OneToMany
    private List<StudentEntity> students;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;
}
