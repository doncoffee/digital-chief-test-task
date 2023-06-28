package com.example.digitalchieftesttask.mapper;

import com.example.digitalchieftesttask.model.dto.FacultyDto;
import com.example.digitalchieftesttask.model.entity.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper implements Mapper<Faculty, FacultyDto> {

    @Override
    public Faculty mapToEntity(FacultyDto object) {
        return Faculty.builder()
                .id(object.getId())
                .name(object.getName())
                .dean(object.getDean())
                .majorQuantity(object.getMajorQuantity())
                .studentQuantity(object.getStudentQuantity())
                .university(object.getUniversity())
                .build();
    }

    @Override
    public FacultyDto mapToDto(Faculty object) {
        return FacultyDto.builder()
                .id(object.getId())
                .name(object.getName())
                .dean(object.getDean())
                .majorQuantity(object.getMajorQuantity())
                .studentQuantity(object.getStudentQuantity())
                .university(object.getUniversity())
                .build();
    }
}
