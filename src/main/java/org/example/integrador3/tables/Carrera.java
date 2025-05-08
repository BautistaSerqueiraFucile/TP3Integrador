package org.example.integrador3.tables;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor (onConstructor = @__(@Autowired))
@NoArgsConstructor (onConstructor = @__(@Autowired))
@Getter
@Setter
@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrera;

    @Column
    private String carrera;

    @Column
    private int duracion;

    @OneToMany (mappedBy = "carrera")
    private List<Estudiante_carrera> carreras;

}
