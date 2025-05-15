package org.example.integrador3.repository;

import org.example.integrador3.repository.dto.carrera.CarreraReporteDTO;
import org.example.integrador3.repository.dto.carrera.EstudiantePorCarreraDTO;
import org.example.integrador3.tables.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepoCarrera")
public interface RepoCarrera extends RepoBase<Carrera, Long>{

    @Query("SELECT NEW org.example.integrador3.repository.dto.carrera.EstudiantePorCarreraDTO(c.carrera, COUNT(ec.estudiante)) " +
            "FROM Estudiante_carrera ec JOIN ec.carrera c " +
            "GROUP BY c.id_carrera, c.carrera, c.duracion " +
            "ORDER BY COUNT(ec.estudiante) DESC")
    List<EstudiantePorCarreraDTO> findCarrerasConMasInscriptos();

    @Query("SELECT NEW org.example.integrador3.repository.dto.carrera.CarreraReporteDTO(" +
               "c.carrera, " +
               "ec.anio_inscripcion, " +
               "COUNT(ec.estudiante), " +
               "SUM(CASE WHEN ec.anio_graduacion IS NOT NULL THEN 1 ELSE 0 END)) " +
           "FROM Estudiante_carrera ec " +
           "JOIN ec.carrera c " +
           "GROUP BY c.carrera, ec.anio_inscripcion " +
           "ORDER BY c.carrera, ec.anio_inscripcion")
    List<CarreraReporteDTO> findReporteCarreras();
}
