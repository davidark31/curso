package com.cursoJava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "adblue")
public class Adblue {

    @Id
    @Getter @Setter @Column(name = "id_adblue", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_adblue;

    @Getter @Setter @Column(name = "litros")
    private double litros;

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Getter @Setter @Column(name = "hora")
    private String hora;

    @Getter @Setter @Column(name = "costo")
    private double costo;

    @Getter @Setter
    @ManyToOne @JoinColumn(name  = "rut_conductor")
    private Conductor conductor;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "nro_bus")
    private Bus bus;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_user")
    private User user;
}
