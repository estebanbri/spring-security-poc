package com.esteban.springsecuritypoc.web.controller;

import com.esteban.springsecuritypoc.model.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosController {

    private static final List<Alumno> ALUMNOS = Arrays.asList(
            new Alumno(1L, "Esteban","Briceno"),
            new Alumno(2L, "Andres","Sati")
    );


    @GetMapping
    public List<Alumno> getAlumnos(){
        return ALUMNOS;
    }

    @GetMapping("/{id}")
    public Alumno getAlumno(@PathVariable Long id){
        return ALUMNOS.stream().filter(alumno->alumno.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public void crearAlumno(@RequestBody Alumno alumno){
        System.out.println("Alumno creado...");
    }
}
