package org.example.integrador3.repository;


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

}
