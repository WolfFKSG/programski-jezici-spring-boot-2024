package com.example.spring_dan1.service;


import com.example.spring_dan1.entity.StudyProgramme;
import com.example.spring_dan1.model.StudyProgrammeModel;
import com.example.spring_dan1.repository.StudyProgrammeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyProgrammeService {

    private final StudyProgrammeRepository repository;

    public List<StudyProgramme> getAllStudyProgrammes(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<StudyProgramme> getStudyProgrammeById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public StudyProgramme saveStudyProgramme(StudyProgrammeModel model){
        StudyProgramme programme = new StudyProgramme();
        programme.setName(model.getName());
        programme.setCreatedAt(LocalDateTime.now());
        return repository.save(programme);
    }
    public StudyProgramme updateStudyProgramme(Integer id, StudyProgrammeModel model){
        StudyProgramme programme = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        programme.setName(model.getName());
        programme.setUpdatedAt(LocalDateTime.now());
        return repository.save(programme);
    }

    public StudyProgramme deletedStudyProgramme(Integer id) {
        StudyProgramme programme = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        programme.setDeletedAt(LocalDateTime.now());
        return repository.save(programme);
    }
}
