package com.cursoJava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "modelo")
public class Modelo {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_modelo", nullable = false)
    private int id_modelo;

    @Getter @Setter @Column(name = "nombre_modelo")
    private String nombre;

    @Getter @Setter @Column(name = "rendimiento")
    private double rendimiento;

    @Getter @Setter @Column(name = "estanque")
    private int estanque;
}
