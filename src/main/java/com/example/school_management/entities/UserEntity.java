package com.example.school_management.entities;

import com.example.school_management.entities.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
@Table(name = "users")
public class UserEntity extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
}
