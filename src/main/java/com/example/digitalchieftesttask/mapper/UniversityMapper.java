package com.example.digitalchieftesttask.mapper;

import com.example.digitalchieftesttask.model.dto.UniversityDto;
import com.example.digitalchieftesttask.model.entity.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityMapper implements Mapper<University, UniversityDto> {

    @Override
    public University mapToEntity(UniversityDto object) {
        return University.builder()
                .id(object.getId())
                .name(object.getName())
                .address(object.getAddress())
                .location(object.getLocation())
                .foundationYear(object.getFoundationYear())
                .build();
    }

    @Override
    public UniversityDto mapToDto(University object) {
        return UniversityDto.builder()
                .id(object.getId())
                .name(object.getName())
                .address(object.getAddress())
                .location(object.getLocation())
                .foundationYear(object.getFoundationYear())
                .build();
    }
}
