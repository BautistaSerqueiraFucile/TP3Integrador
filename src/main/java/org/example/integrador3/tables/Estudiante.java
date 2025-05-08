package org.example.integrador3.tables;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor (onConstructor = @__(@Autowired))
@NoArgsConstructor (onConstructor = @__(@Autowired))
@Getter
@Setter
@Entity
public class Estudiante {

    @Id
    private int dni_estudiante;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String apellido;

    @Column (nullable = false)
    private int edad;

    @Column
    private String genero;

    @Column
    private String ciudad;

    @Column (nullable = false)
    private int lu;

    @OneToMany (mappedBy = "estudiante")
    private List<Estudiante_carrera> carreras;

}
