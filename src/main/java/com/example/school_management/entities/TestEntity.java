package com.example.school_management.entities;

import com.example.school_management.converters.Encrypt;
import com.example.school_management.entities.abstracts.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tests")
public class TestEntity extends AbstractEntity {

    @Convert(converter = Encrypt.class)
    @Column(nullable = false)
    private String message;

    private String description;
}
