package com.example.digitalchieftesttask.service.impl;

import com.example.digitalchieftesttask.mapper.UniversityMapper;
import com.example.digitalchieftesttask.model.dto.UniversityDto;
import com.example.digitalchieftesttask.model.entity.University;
import com.example.digitalchieftesttask.model.repo.UniversityRepository;
import com.example.digitalchieftesttask.service.UniversityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UniversityServiceImpl implements UniversityService {

    private final UniversityMapper universityMapper;
    private final UniversityRepository universityRepository;

    @Override
    public UniversityDto createUniversity(UniversityDto universityDto) {
        return Optional.of(universityDto)
                .map(universityMapper::mapToEntity)
                .map(universityRepository::save)
                .map(universityMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public List<UniversityDto> findAllUniversities() {
        return universityRepository.findAll().stream()
                .map(universityMapper::mapToDto)
                .toList();
    }

    @Override
    public Optional<UniversityDto> updateUniversity(Long id, UniversityDto universityDto) {
        return universityRepository.findById(id)
                .map(entity -> copy(universityDto, entity))
                .map(universityRepository::save)
                .map(universityMapper::mapToDto);
    }

    @Override
    public boolean deleteUniversity(Long id) {
        return universityRepository.findById(id)
                .map(entity -> {
                    universityRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public Optional<UniversityDto> findUniversityById(Long id) {
        return universityRepository.findById(id)
                .map(universityMapper::mapToDto);
    }

    private University copy(UniversityDto universityDto, University university) {
        university.setId(universityDto.getId());
        university.setName(universityDto.getName());
        university.setAddress(universityDto.getAddress());
        university.setLocation(universityDto.getLocation());
        university.setFoundationYear(universityDto.getFoundationYear());
        return university;
    }
}
