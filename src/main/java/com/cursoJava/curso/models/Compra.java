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
public class Compra {

    @Id
    @Getter @Setter @Column(name = "id_compra", nullable = false)
    private int id_compra;

    @Getter @Setter @Column(name = "cantidad")
    private int cantidad;

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Getter @Setter @Column(name = "costo")
    private double costo;

    @Getter @Setter @Column(name = "nro_factura")
    private int nro_factura;

    @Getter @Setter @Column(name = "valor_litro")
    private double valor_litro;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}