package com.example.digitalchieftesttask.controller;

import com.example.digitalchieftesttask.model.dto.FacultyDto;
import com.example.digitalchieftesttask.service.FacultyService;
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
@RequestMapping("/api/v1/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping
    public FacultyDto create(@RequestBody FacultyDto facultyDto) {
        return facultyService.createFaculty(facultyDto);
    }

    @GetMapping
    public List<FacultyDto> getAll() {
        return facultyService.findAllFaculties();
    }

    @GetMapping("/{id}")
    public FacultyDto findById(@PathVariable Long id) {
        return facultyService.findFacultyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public FacultyDto update(@PathVariable Long id,
                                @RequestBody FacultyDto facultyDto) {
        return facultyService.updateFaculty(id, facultyDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return facultyService.deleteFaculty(id)
                ? noContent().build()
                : notFound().build();
    }
}
