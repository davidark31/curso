package com.cursoJava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_empresa",nullable = false)
    private int id_empresa;

    @Getter @Setter @Column(name = "nombre_empresa")
    private String nombre;

    @Getter @Setter @Column(name = "combustible")
    private double combustible;
}
