package com.example.school_management.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassDto {
    private Long id;
    private String name;
    private List<SectionDto> sections;
}
