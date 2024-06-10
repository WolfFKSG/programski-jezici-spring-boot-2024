package com.example.spring_dan1.repository;

import com.example.spring_dan1.entity.StudyProgramme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudyProgrammeRepository extends JpaRepository<StudyProgramme, Integer> {

    List<StudyProgramme> findAllByDeletedAtIsNull();
    Optional<StudyProgramme> findByIdAndDeletedAtIsNull(Integer id);


}
