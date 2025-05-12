package org.example.integrador3.controllers;

import org.example.integrador3.services.EstudianteService;
import org.example.integrador3.tables.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("")
    public ResponseEntity<?> getAllbyEdad(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findAllbyEdad());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("carrera/{carrera}/ciudad/{ciudad}")
    public ResponseEntity<?> getAllByCarreraCiudad(@PathVariable String carrera, @PathVariable String ciudad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findAllByCarreraCiudad(carrera, ciudad));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("legajo/{lu}")
    public ResponseEntity<?> getAllbyLU(@PathVariable int lu){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findByLU(lu));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("genero/{genero}")
    public ResponseEntity<?> getAllbyGenero(@PathVariable String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findByGenero(genero));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }


}
