package com.esteban.springsecuritypoc.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private static final List<com.esteban.springsecuritypoc.model.Alumno> ALUMNOS = Arrays.asList(
            new com.esteban.springsecuritypoc.model.Alumno(1L, "Esteban","Briceno"),
            new com.esteban.springsecuritypoc.model.Alumno(2L, "Andres","Sati")
    );

    @GetMapping
    public List<com.esteban.springsecuritypoc.model.Alumno> getAlumnos(){
        return ALUMNOS;
    }

}
