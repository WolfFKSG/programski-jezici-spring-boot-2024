package com.example.spring_dan1.service;

import com.example.spring_dan1.entity.Student;
import com.example.spring_dan1.model.StudentModel;
import com.example.spring_dan1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor                                            // za autowire
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Student> getStudentById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public List<Student> getStudentByIndeks(String indeks){
        return repository.findByIndeksContainsAndDeletedAtIsNull(indeks);
    }

    public Student createStudent(StudentModel model){
        Student student = new Student();
        student.setName(model.getName());
        student.setSurname(model.getSurname());
        student.setIndeks(model.getIndeks());
        student.setCreatedAt(LocalDateTime.now());
        return repository.save(student);
    }

    public Student updateStudent(Integer id, StudentModel model) {
        Student student=repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        student.setName(model.getName());
        student.setSurname(model.getSurname());
        student.setIndeks(model.getIndeks());
        student.setUpdatedAt(LocalDateTime.now());
        return repository.save(student);
    }

    public void deleteStudent(Integer id){
        Student student=repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        student.setDeletedAt(LocalDateTime.now());
        repository.save(student);
    }
}
