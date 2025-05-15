package org.example.integrador3.controllers;

import org.example.integrador3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carService;

    @GetMapping("")
    public ResponseEntity<?> getCarrerasConMasInscriptos(){ //c
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carService.findCarrerasConMasInscriptos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("reporte")
    public ResponseEntity<?> getReporteCarreras(){ //h
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carService.findReporteCarreras());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

}
