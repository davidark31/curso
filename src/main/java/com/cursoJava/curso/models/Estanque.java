package com.cursoJava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "estanque")
public class Estanque {

    @Id
    @Getter
    @Setter
    @Column(name = "id_estanque", nullable = false)
    private int id_estanque;

    @Getter @Setter @Column(name = "litros_medidos")
    private int litros_medidos;

    @Getter @Setter @Column(name = "litros_supuestos")
    private double litros_supuestos;

    @Getter @Setter @Column(name = "diferencia")
    private double diferencia;

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_user")
    private User user;
}
