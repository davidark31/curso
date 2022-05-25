package com.cursoJava.curso.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "carga")
public class Carga {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_carga", nullable = false)
    private Long id_carga;

    @Getter @Setter @Column(name="patente")
    private String patente;

    @Getter @Setter @Column(name="nro_bus")
    private int nro_bus;

    @Getter @Setter @Column(name="kil_ini")
    private int kil_ini;

    @Getter @Setter @Column(name="kil_act")
    private int kil_act;

    @Getter @Setter @Column(name="litros_carg")
    private double litros_carg;

    @Getter @Setter @Column(name="fecha")
    private Date fecha;

    @Getter @Setter @Column(name="costo")
    private double costo;

    @Getter @Setter @Column(name="rut_conductor")
    private String rut_conductor;

    @Getter @Setter @Column(name="id_usu")
    private int id_usu;
}