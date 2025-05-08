package org.example.integrador3.utils;

import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.integrador3.repository.RepoCarrera;
import org.example.integrador3.repository.RepoEstudiante;
import org.example.integrador3.repository.RepoEstudianteCarrera;
import org.example.integrador3.tables.Carrera;
import org.example.integrador3.tables.Estudiante;
import org.example.integrador3.tables.Estudiante_carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Component
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class CargaDeDatos {

    private final RepoCarrera repoCarrera;
    private final RepoEstudiante repoEstudiante;
    private final RepoEstudianteCarrera repoEstudianteCarrera;

    public void cargarDatosDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/resources/csv/estudiantes.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setDni_estudiante(Integer.parseInt(csvRecord.get("DNI")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setLu(Integer.parseInt(csvRecord.get("LU")));
                repoEstudiante.save(estudiante); // Guarda el perro en la base de datos
            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/resources/csv/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
        CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setCarrera(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                carrera.setCarreras(new ArrayList<>());
                repoCarrera.save(carrera);
            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/resources/csv/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Estudiante_carrera estudiante_carrera = new Estudiante_carrera();
                Optional<Estudiante> opt = repoEstudiante.findById(Long.parseLong(csvRecord.get("id_estudiante")));
                if (opt.isPresent()) {
                    Estudiante est = opt.get();
                    estudiante_carrera.setEstudiante(est);
                }
                Optional<Carrera> opt2 = repoCarrera.findById(Long.parseLong(csvRecord.get("id_carrera")));
                if (opt2.isPresent()){
                    Carrera car = opt2.get();
                    estudiante_carrera.setCarrera(car);
                }
                estudiante_carrera.setAnio_inscripcion(Integer.parseInt(csvRecord.get("inscripcion")));
                estudiante_carrera.setAnio_graduacion(Integer.parseInt(csvRecord.get("graduacion")));
                estudiante_carrera.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));

                repoEstudianteCarrera.save(estudiante_carrera);
            }
        }
    }

}
