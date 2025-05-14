package org.example.integrador3.services;

import jakarta.transaction.Transactional;
import org.example.integrador3.repository.RepoCarrera;
import org.example.integrador3.repository.RepoEstudiante;
import org.example.integrador3.repository.RepoEstudianteCarrera;
import org.example.integrador3.repository.dto.estudiante_carrera.MatricularEstudianteDTO;
import org.example.integrador3.tables.Carrera;
import org.example.integrador3.tables.Estudiante;
import org.example.integrador3.tables.Estudiante_carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EstudianteCarreraService")
public class EstudianteCarreraService implements  BaseService<Estudiante_carrera>{

    @Autowired
    private RepoEstudianteCarrera repoEst_car;
    @Autowired
    private RepoEstudiante repoEst;
    @Autowired
    private RepoCarrera repoCar;

    @Transactional
    public Estudiante_carrera matricularEstudiante(MatricularEstudianteDTO mat_est) throws Exception {
        try {
            long id_carrera = Long.valueOf(mat_est.getId_carrera());
            long id_estudiante = Long.valueOf(mat_est.getDni_estudiante());
            if (repoCar.existsById(id_carrera) && repoEst.existsById(id_estudiante)) {
                Carrera car = repoCar.findById(id_carrera).get();
                Estudiante est = repoEst.findById(id_estudiante).get();
                Estudiante_carrera est_car = new Estudiante_carrera(est, car, mat_est.getAnio_inscripcion());
                return repoEst_car.save(est_car);
            }
            else return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Estudiante_carrera findById(Long id) throws Exception {
        try{
            if (repoEst_car.findById(id).isPresent()){
                return repoEst_car.findById(id).get();
            }
            return null;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante_carrera save(Estudiante_carrera entity) throws Exception {
        try{
            return repoEst_car.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante_carrera update(Long id, Estudiante_carrera entity) throws Exception {
        try{
            if (repoEst_car.findById(id).isPresent()){
                Estudiante_carrera est_car = repoEst_car.findById(id).get();
                est_car = repoEst_car.save(entity);
                return est_car;
            }
            return null;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
