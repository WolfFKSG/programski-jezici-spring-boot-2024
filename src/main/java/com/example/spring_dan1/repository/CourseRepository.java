package com.example.spring_dan1.repository;

import com.example.spring_dan1.entity.Course;
import com.example.spring_dan1.entity.StudyProgramme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByDeletedAtIsNull();
    Optional<Course> findByIdAndDeletedAtIsNull(Integer id);

}
