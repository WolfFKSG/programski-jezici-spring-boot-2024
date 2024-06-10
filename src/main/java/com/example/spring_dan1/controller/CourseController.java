package com.example.spring_dan1.controller;


import com.example.spring_dan1.entity.Course;
import com.example.spring_dan1.entity.StudyProgramme;
import com.example.spring_dan1.model.NameModel;
import com.example.spring_dan1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/course")
public class CourseController {

    private final CourseService service;

    @GetMapping
    public List<Course> getAll() {
        return service.getAllCourse();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Course> getById(@PathVariable Integer id){
        return ResponseEntity.of(service.getCourseById(id));
    }

    @PostMapping
    public Course create(@RequestBody NameModel model) {
        return service.saveCourse(model);
    }

    @PutMapping(path = "/{id}")
    public Course update(@PathVariable Integer id, @RequestBody NameModel model) {
        return service.updateCourse(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.deletedCourse(id);
    }
}
