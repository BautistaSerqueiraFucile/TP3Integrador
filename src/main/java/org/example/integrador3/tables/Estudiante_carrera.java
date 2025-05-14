package org.example.integrador3.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Estudiante_carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudiante_carrera;

    @ManyToOne
    @JoinColumn (name = "dni_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn (name = "id_carrera")
    private Carrera carrera;

    @Column (nullable = false)
    private int anio_inscripcion;

    @Column
    private int anio_graduacion;

    @Column
    private int antiguedad;

    public Estudiante_carrera(Estudiante est, Carrera car, int anio_inscripcion) {
        this.estudiante = est;
        this.carrera = car;
        this.anio_inscripcion = anio_inscripcion;
        this.anio_graduacion = 0;
        this.antiguedad = 0;
    }
}
