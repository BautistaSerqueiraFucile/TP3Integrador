package org.example.integrador3.repository.dto.carrera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarreraReporteDTO {

    private String nombreCarrera;
    private int anioInscripcion;
    private long inscriptos;
    private long egresados;

    @Override
    public String toString() {
        return "\n{" +
                "nombreCarrera='" + nombreCarrera + "\n" +
                ", Año inscripcion=" + anioInscripcion + "\n" +
                ", cantidad inscriptos=" + anioInscripcion + "\n" +
                ", cantidad graduados=" + anioInscripcion + "\n" +
                "}";
    }
}

