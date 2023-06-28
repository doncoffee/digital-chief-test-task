package com.example.digitalchieftesttask.model.dto;

import com.example.digitalchieftesttask.model.entity.University;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FacultyDto {
    Long id;
    String name;
    Integer studentQuantity;
    Integer majorQuantity;
    String dean;
    University university;
}
