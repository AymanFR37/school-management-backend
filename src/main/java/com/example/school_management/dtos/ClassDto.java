package com.example.school_management.dtos;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassDto {
    private UUID id;
    private String name;
    private List<SectionDto> sections;
}
