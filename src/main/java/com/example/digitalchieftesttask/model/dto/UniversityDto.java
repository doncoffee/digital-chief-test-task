package com.example.digitalchieftesttask.model.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UniversityDto {
    Long id;
    String name;
    String location;
    String address;
    LocalDate foundationYear;
}
