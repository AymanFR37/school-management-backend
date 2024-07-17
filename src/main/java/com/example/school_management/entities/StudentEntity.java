package com.example.school_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class StudentEntity extends UserEntity {
    private String address;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;
    @OneToMany(mappedBy = "student")
    private List<AttendanceEntity> attendance;
}
