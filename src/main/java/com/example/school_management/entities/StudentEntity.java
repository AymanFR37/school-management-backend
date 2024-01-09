package com.example.school_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class StudentEntity extends UserEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private LocalDate dateOfBirth;
//    I could found the class from the section
//    @ManyToOne
//    @JoinColumn(name = "class_id")
//    private ClassEntity studentClass;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;
    @OneToMany(mappedBy = "student")
    private List<AttendanceEntity> attendance;
}
