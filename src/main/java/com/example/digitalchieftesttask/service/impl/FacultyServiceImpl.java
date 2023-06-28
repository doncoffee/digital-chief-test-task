package com.example.digitalchieftesttask.service.impl;

import com.example.digitalchieftesttask.mapper.FacultyMapper;
import com.example.digitalchieftesttask.model.dto.FacultyDto;
import com.example.digitalchieftesttask.model.entity.Faculty;
import com.example.digitalchieftesttask.model.repo.FacultyRepository;
import com.example.digitalchieftesttask.service.FacultyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FacultyServiceImpl implements FacultyService {

    private final FacultyMapper facultyMapper;
    private final FacultyRepository facultyRepository;

    @Override
    public FacultyDto createFaculty(FacultyDto facultyDto) {
        return Optional.of(facultyDto)
                .map(facultyMapper::mapToEntity)
                .map(facultyRepository::save)
                .map(facultyMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public List<FacultyDto> findAllFaculties() {
        return facultyRepository.findAll().stream()
                .map(facultyMapper::mapToDto)
                .toList();
    }

    @Override
    public Optional<FacultyDto> updateFaculty(Long id, FacultyDto facultyDto) {
        return facultyRepository.findById(id)
                .map(entity -> copy(facultyDto, entity))
                .map(facultyRepository::save)
                .map(facultyMapper::mapToDto);
    }

    @Override
    public boolean deleteFaculty(Long id) {
        return facultyRepository.findById(id)
                .map(entity -> {
                    facultyRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Optional<FacultyDto> findFacultyById(Long id) {
        return facultyRepository.findById(id)
                .map(facultyMapper::mapToDto);
    }

    private Faculty copy(FacultyDto facultyDto, Faculty faculty) {
        faculty.setId(facultyDto.getId());
        faculty.setName(facultyDto.getName());
        faculty.setDean(facultyDto.getDean());
        faculty.setUniversity(facultyDto.getUniversity());
        faculty.setMajorQuantity(facultyDto.getMajorQuantity());
        faculty.setStudentQuantity(facultyDto.getStudentQuantity());
        return faculty;
    }
}
