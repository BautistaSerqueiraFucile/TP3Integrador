package org.example.integrador3.repository.dto.estudiante_carrera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
public class MatricularEstudianteDTO {

    private int id_carrera;
    private int dni_estudiante;
    private int anio_inscripcion;

    @Override
    public String toString() {
        return "{" +
                "id_carrera=" + id_carrera +
                ", dni_estudiante=" + dni_estudiante +
                ", año_inscripcion=" + anio_inscripcion +
                '}';
    }
}
