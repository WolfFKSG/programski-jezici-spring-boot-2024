package com.example.spring_dan1.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionModel {

    private String name;            //uzimamo ime gde doslo do greske
    private String path;            //path gde je doslo do greske
    private String message;         //polje u koje upisujemo gresku koju izbaci
}
