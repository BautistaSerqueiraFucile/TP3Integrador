package org.example.integrador3.services;

import org.example.integrador3.dto.EstudianteCarreraCiudadDTO;
import org.example.integrador3.dto.EstudianteDTO;
import org.example.integrador3.dto.EstudiantePorCarreraDTO;
import org.example.integrador3.repository.RepoEstudiante;
import org.example.integrador3.tables.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("EstudianteService")
public class EstudianteService implements BaseService<Estudiante> {

    @Autowired
    private RepoEstudiante repoEst;

    @Transactional
    public List<EstudianteDTO> findByGenero(String genero) throws Exception{
        List<Estudiante> listEst = repoEst.findByGenero(genero);
        return createEstudianteDTO(listEst);
    }

    @Transactional
    public List<EstudianteDTO> findAllbyEdad() throws Exception {
        List<Estudiante> listEst = repoEst.findAllByEdad();
        return createEstudianteDTO(listEst);
    }

    @Transactional
    public List<EstudianteCarreraCiudadDTO> findAllByCarreraCiudad(String carrera, String ciudad) throws Exception {
        return repoEst.findAllByCarreraCiudad(carrera, ciudad);
    }

    @Transactional
    public List<EstudianteDTO> findByLU(int lu) throws Exception {
        List<Estudiante> listEst = repoEst.findByLU(lu);
        return createEstudianteDTO(listEst);
    }

    @Override
    @Transactional
    public Estudiante findById(Long id) throws Exception {
        try{
            return repoEst.findById(id).get();
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
            Estudiante est = repoEst.findById(id).get();
            est = repoEst.save(entity);
            return est;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    private List<EstudianteDTO> createEstudianteDTO(List<Estudiante> listEst) throws Exception {
        List<EstudianteDTO> listEstDto = new ArrayList<>();
        try{
            for (Estudiante est : listEst) {
                listEstDto.add(new EstudianteDTO(est.getDni_estudiante(), est.getNombre(), est.getApellido(), est.getEdad() ,est.getGenero(), est.getCiudad(), est.getLu()));
            }
            return listEstDto;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
