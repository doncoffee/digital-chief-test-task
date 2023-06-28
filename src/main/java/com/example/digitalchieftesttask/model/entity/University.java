package com.example.digitalchieftesttask.model.entity;

import com.example.digitalchieftesttask.model.entity.Faculty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String address;

    @Column(name = "foundation_year")
    private LocalDate foundationYear;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Faculty> faculty = new ArrayList<>();
}
