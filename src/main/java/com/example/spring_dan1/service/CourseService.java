package com.example.spring_dan1.service;

import com.example.spring_dan1.entity.Course;
import com.example.spring_dan1.entity.StudyProgramme;
import com.example.spring_dan1.model.NameModel;
import com.example.spring_dan1.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public List<Course> getAllCourse(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Course> getCourseById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Course saveCourse(NameModel model){
        Course course = new Course();
        course.setName(model.getName());
        course.setCreatedAt(LocalDateTime.now());
        return repository.save(course);
    }
    public Course updateCourse(Integer id, NameModel model){
        Course course = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        course.setName(model.getName());
        course.setUpdatedAt(LocalDateTime.now());
        return repository.save(course);
    }

    public void deletedCourse(Integer id) {
        Course course = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        course.setDeletedAt(LocalDateTime.now());
        repository.save(course);
    }

}
