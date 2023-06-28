package com.example.digitalchieftesttask.service;

import com.example.digitalchieftesttask.model.dto.FacultyDto;

import java.util.List;
import java.util.Optional;

public interface FacultyService {

    FacultyDto createFaculty(FacultyDto facultyDto);
    List<FacultyDto> findAllFaculties();
    Optional<FacultyDto> updateFaculty(Long id, FacultyDto facultyDto);
    boolean deleteFaculty(Long id);
    Optional<FacultyDto> findFacultyById(Long id);
}
