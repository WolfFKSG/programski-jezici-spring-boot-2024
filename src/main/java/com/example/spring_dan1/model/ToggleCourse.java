package com.example.spring_dan1.model;

import com.example.spring_dan1.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ToggleCourse {
    private Boolean active;
    private Course course;
}
