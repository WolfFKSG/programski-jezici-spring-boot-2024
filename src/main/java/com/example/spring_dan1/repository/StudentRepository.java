package com.example.spring_dan1.repository;

import com.example.spring_dan1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Ovo je interfejs koji sluzi za custom upite u bazi
public interface StudentRepository extends JpaRepository<Student, Integer> {    //ekstenduje JPA, koji uzima tabelu i tip IDja

    List<Student> findAllByDeletedAtIsNull();

    Optional<Student> findByIdAndDeletedAtIsNull(Integer id);

    List<Student> findByIndeksContainsAndDeletedAtIsNull(String indeks);



}
