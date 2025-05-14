package org.example.integrador3.repository.dto.estudiante_carrera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class MatricularEstudianteDTO {

    private int id_carrera;
    private int dni_estudiante;
    private int anio_inscripcion;
}
