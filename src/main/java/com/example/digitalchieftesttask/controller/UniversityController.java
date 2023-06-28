package com.example.digitalchieftesttask.controller;

import com.example.digitalchieftesttask.model.dto.UniversityDto;
import com.example.digitalchieftesttask.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/universities")
public class UniversityController {

    private final UniversityService universityService;

    @PostMapping
    public UniversityDto create(@RequestBody UniversityDto universityDto) {
        return universityService.createUniversity(universityDto);
    }

    @GetMapping
    public List<UniversityDto> getAll() {
        return universityService.findAllUniversities();
    }

    @GetMapping("/{id}")
    public UniversityDto findById(@PathVariable Long id) {
        return universityService.findUniversityById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public UniversityDto update(@PathVariable Long id,
                                @RequestBody UniversityDto universityDto) {
        return universityService.updateUniversity(id, universityDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return universityService.deleteUniversity(id)
                ? noContent().build()
                : notFound().build();
    }
}
