package org.example.integrador3.repository;

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

}
