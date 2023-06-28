package com.example.digitalchieftesttask.service;

import com.example.digitalchieftesttask.model.dto.UniversityDto;

import java.util.List;
import java.util.Optional;

public interface UniversityService {

    UniversityDto createUniversity(UniversityDto universityDto);
    List<UniversityDto> findAllUniversities();
    Optional<UniversityDto> updateUniversity(Long id, UniversityDto universityDto);
    boolean deleteUniversity(Long id);
    Optional<UniversityDto> findUniversityById(Long id);
}
