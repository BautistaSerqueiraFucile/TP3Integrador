package org.example.integrador3.repository;


import org.example.integrador3.tables.Estudiante_carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepoEstudianteCarrera")
public interface RepoEstudianteCarrera extends RepoBase<Estudiante_carrera, Long>{

}
