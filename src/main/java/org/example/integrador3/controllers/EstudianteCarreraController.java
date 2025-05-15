package org.example.integrador3.controllers;


import org.example.integrador3.repository.dto.estudiante_carrera.EstudianteCarreraDTO;
import org.example.integrador3.repository.dto.estudiante_carrera.MatricularEstudianteDTO;
import org.example.integrador3.services.EstudianteCarreraService;
import org.example.integrador3.tables.Estudiante;
import org.example.integrador3.tables.Estudiante_carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricular")
public class EstudianteCarreraController {

    @Autowired
    private EstudianteCarreraService est_carService;

    @PostMapping("") //b
    public ResponseEntity<?> save(@RequestBody MatricularEstudianteDTO entity){
        try{
            Estudiante_carrera response = est_carService.matricularEstudiante(entity);
            if (response != null)
                return ResponseEntity.status(HttpStatus.OK).body(entity);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el estudiante o la carrera");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }

}
