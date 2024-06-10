package com.example.spring_dan1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "student")                                                    //ide ime tabele iz baze u entity
@NoArgsConstructor                                                           //lombok anotacije za kreiranje konstruktora, gettera i settera
@Getter                                                                      //za sva polja
@Setter
public class Student {                                                       //klasa Student koja reprezentuje jednu tabelu u SQL

    @Id                                                                      //pomocu anotacija ( koji su zapravo interfejsi) implementujemo
    @GeneratedValue(strategy = GenerationType.IDENTITY)                      //student_id kolonu i smestamo je u promenjljlivu id
    @Column(name = "student_id")
    private Integer id;

    @Column(nullable = false)                                               //spring sam zna da ide redom pa ne upisujemo imena kolona
    private String name;                                                    //stavljamo nullable false posto ta polja su non null u bazi

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)                                //dodatno stavljamo da je unique key
    private String indeks;

    @ManyToOne(optional = false)                                            //dodavanje many to one relacije izmedju 2 baze
    @JoinColumn(name = "study_programme_id", nullable = false)
    private StudyProgramme studyProgramme;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
                name = "student_course",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Course> courses;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    //sad ne stavljamo column posto je nullabilna tabela za updated at po defaultu
    private LocalDateTime updatedAt;

    @JsonIgnore                 //ignorise ga u svim ostalim json fajlovima, ali idalje moze da se koristi u app
    private LocalDateTime deletedAt;

}
