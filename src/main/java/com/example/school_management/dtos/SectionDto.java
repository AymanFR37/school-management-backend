package com.example.school_management.dtos;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SectionDto {
    private UUID id;
    private String name;
    private ClassDto classEntity;
}
