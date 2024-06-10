package com.example.spring_dan1.controller;

import com.example.spring_dan1.entity.Student;
import com.example.spring_dan1.model.StudentModel;
import com.example.spring_dan1.model.ToggleCourse;
import com.example.spring_dan1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")                          //dodavanje kontrolera i mapiranja putanje u linku
@RequiredArgsConstructor                                        //automatski konstruktor za studentrepository
@CrossOrigin
public class StudentController {                                //sluzi za mapiranje ka nekoj putanji

    private final StudentService service;

    @GetMapping                                                   //get request ka cemu hocemo
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) { //response entity umesto studenta samo zbog dobijanja greske odma
        //na serveru ako nema student
        return ResponseEntity.of(service.getStudentById(id));                      //trazi studenta po IDu iz repozitorijuma

    }

    @GetMapping(path ="/indeks/{indeks}")
    public List<Student> getStudentByIndeks(@PathVariable String indeks){
        return service.getStudentByIndeks(indeks);
    }

    @PostMapping                                                                    //postuje studenta po konstuktorskom telu
    public Student createStudent(@RequestBody StudentModel student) {
        return service.createStudent(student);
    }

    @PutMapping(path = "/{id}")                                                     //updatujemo, stavljamo u link /id korisnika
    public Student updateStudent(@PathVariable Integer id,@RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    //many to many stuff, dont add; add from deletemapping
    @PutMapping(path = "/course/{id}")
    public void toggleCourse(@PathVariable Integer id, @RequestBody ToggleCourse model) {
        service.toggleCourseForStudentId(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }


}
