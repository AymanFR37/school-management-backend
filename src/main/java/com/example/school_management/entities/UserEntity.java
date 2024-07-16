package com.example.school_management.entities;

import com.example.school_management.entities.abstracts.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@MappedSuperclass
@Table(name = "users")
public class UserEntity extends AbstractEntity {
    private String email;
    private String password;

}
