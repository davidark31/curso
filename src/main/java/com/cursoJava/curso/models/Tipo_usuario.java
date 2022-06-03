package com.cursoJava.curso.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name= "tipousuario")
public class Tipo_usuario {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_tipo", nullable = false)
    private int id_tipo;

    @Getter @Setter @Column(name = "nombre_tipo")
    private String nombre_tipo;
}
