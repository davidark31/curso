package com.cursoJava.curso.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "conductor")
public class Conductor {


    @Id
    @Getter
    @Setter
    @Column(name = "rut_conductor", nullable = false)
    private String rut;

    @Getter @Setter
    @Column(name = "nombre_conductor")
    private String nombre_conductor;

    @Getter @Setter
    @Column(name = "autorizado")
    private int autorizado;
}