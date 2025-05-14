package org.example.integrador3.services;


import jakarta.transaction.Transactional;
import org.example.integrador3.repository.dto.carrera.EstudiantePorCarreraDTO;
import org.example.integrador3.repository.RepoCarrera;
import org.example.integrador3.tables.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarreraService")
public class CarreraService implements BaseService<Carrera> {

    @Autowired
    private RepoCarrera repoCar;


    @Transactional
    public List<EstudiantePorCarreraDTO> findCarrerasConMasInscriptos(){
        return repoCar.findCarrerasConMasInscriptos();
    }

    @Override
    @Transactional
    public Carrera findById(Long id) throws Exception {
        try{
            if (repoCar.findById(id).isPresent()){
                return repoCar.findById(id).get();
            }
            return null;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Carrera save(Carrera entity) throws Exception {
        try{
            return repoCar.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Carrera update(Long id, Carrera entity) throws Exception {
        try{
            if (repoCar.findById(id).isPresent()){
                Carrera car = repoCar.findById(id).get();
                car = repoCar.save(entity);
                return car;
            }
            return null;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
