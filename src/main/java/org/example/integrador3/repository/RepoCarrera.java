package org.example.integrador3.repository;

import org.example.integrador3.tables.Carrera;
import org.springframework.stereotype.Repository;

@Repository("RepoCarrera")
public interface RepoCarrera extends RepoBase<Carrera, Long>{

}
