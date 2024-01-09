package com.example.school_management.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SectionDto {
    private Long id;
    private String name;
    private ClassDto classEntity;
}
