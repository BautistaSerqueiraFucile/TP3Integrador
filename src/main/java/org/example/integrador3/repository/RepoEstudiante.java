package org.example.integrador3.repository;


import org.example.integrador3.dto.EstudianteCarreraCiudadDTO;
import org.example.integrador3.dto.EstudiantePorCarreraDTO;
import org.example.integrador3.tables.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepoEstudiante")
public interface RepoEstudiante extends RepoBase<Estudiante, Long>{

    @Query ("SELECT e FROM Estudiante e ORDER BY e.edad")
    List<Estudiante> findAllByEdad();

    @Query ("SELECT e FROM Estudiante e WHERE e.lu = :lu")
    List<Estudiante> findByLU(int lu);

    @Query ("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<Estudiante> findByGenero(String genero);

    @Query ("SELECT NEW org.example.integrador3.dto.EstudianteCarreraCiudadDTO (e.nombre, e.apellido, e.dni_estudiante, c.carrera, e.ciudad) " +
            "FROM Estudiante_carrera ec JOIN ec.estudiante e JOIN ec.carrera c " +
            "WHERE c.carrera = :carrera AND e.ciudad = :ciudad")
    List<EstudianteCarreraCiudadDTO> findAllByCarreraCiudad(String carrera, String ciudad);
}
