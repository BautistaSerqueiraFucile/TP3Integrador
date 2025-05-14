package org.example.integrador3.repository;


import org.example.integrador3.repository.dto.estudiante.EstudianteCarreraCiudadDTO;
import org.example.integrador3.repository.dto.estudiante.EstudianteDTO;
import org.example.integrador3.tables.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepoEstudiante")
public interface RepoEstudiante extends RepoBase<Estudiante, Long>{

    @Query ("SELECT NEW org.example.integrador3.repository.dto.estudiante.EstudianteDTO(e.dni_estudiante, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.lu)" +
            "FROM Estudiante e ORDER BY e.edad")
    List<EstudianteDTO> findAllByEdad();

    @Query ("SELECT NEW org.example.integrador3.repository.dto.estudiante.EstudianteDTO(e.dni_estudiante, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.lu) " +
            "FROM Estudiante e WHERE e.lu = :lu")
    List<EstudianteDTO> findByLU(int lu);

    @Query ("SELECT NEW org.example.integrador3.repository.dto.estudiante.EstudianteDTO(e.dni_estudiante, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.lu)" +
            "FROM Estudiante e WHERE e.genero = :genero")
    List<EstudianteDTO> findByGenero(String genero);

    @Query ("SELECT NEW org.example.integrador3.repository.dto.estudiante.EstudianteCarreraCiudadDTO (e.nombre, e.apellido, e.dni_estudiante, c.carrera, e.ciudad) " +
            "FROM Estudiante_carrera ec JOIN ec.estudiante e JOIN ec.carrera c " +
            "WHERE c.carrera = :carrera AND e.ciudad = :ciudad")
    List<EstudianteCarreraCiudadDTO> findAllByCarreraCiudad(String carrera, String ciudad);
}
