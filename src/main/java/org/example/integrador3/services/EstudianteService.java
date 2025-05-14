package org.example.integrador3.services;

import org.example.integrador3.repository.dto.estudiante.EstudianteCarreraCiudadDTO;
import org.example.integrador3.repository.dto.estudiante.EstudianteDTO;
import org.example.integrador3.repository.RepoEstudiante;
import org.example.integrador3.tables.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EstudianteService")
public class EstudianteService implements BaseService<Estudiante> {

    @Autowired
    private RepoEstudiante repoEst;

    @Transactional
    public List<EstudianteDTO> findByGenero(String genero) throws Exception{
        return repoEst.findByGenero(genero);
    }

    @Transactional
    public List<EstudianteDTO> findAllbyEdad() throws Exception {
        return repoEst.findAllByEdad();
    }

    @Transactional
    public List<EstudianteCarreraCiudadDTO> findAllByCarreraCiudad(String carrera, String ciudad) throws Exception {
        return repoEst.findAllByCarreraCiudad(carrera, ciudad);
    }

    @Transactional
    public List<EstudianteDTO> findByLU(int lu) throws Exception {
        return repoEst.findByLU(lu);
    }

    @Override
    @Transactional
    public Estudiante findById(Long id) throws Exception {
        try{
            if (repoEst.findById(id).isPresent()) {
                return repoEst.findById(id).get();
            }
            return null;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        try{
            return repoEst.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        try{
            if (repoEst.findById(id).isPresent()){
                Estudiante est = repoEst.findById(id).get();
                est = repoEst.save(entity);
                return est;
            }
            return null;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
