package com.cursoJava.curso.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "bus")
public class Bus {

    @Id
    @Getter @Setter @Column(name = "patente", nullable = false)
    private String patente;

    @Getter @Setter @Column(name="nro_bus")
    private int nro_bus;

    @Getter @Setter @Column(name="kilometraje")
    private int kilometraje;

    @Getter @Setter @Column(name="asientos")
    private int asientos;

    @Getter @Setter @Column(name="ano")
    private int año;

    @Getter @Setter @Column(name="nro_motor")
    private String nro_motor;

    @Getter @Setter @Column(name="nro_chasis")
    private String nro_chasis;

    @Getter @Setter @Column(name="nro_carroceria")
    private String nro_carroceria;

    @Getter @Setter
    @ManyToOne @JoinColumn(name="id_modelo")
    private Modelo modelo;

    @Getter @Setter
    @ManyToOne @JoinColumn(name="id_empresa")
    private Empresa empresa;
}
