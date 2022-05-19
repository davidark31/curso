package com.cursoJava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString @EqualsAndHashCode
@Table(name= "usuario")
public class User {

    @Id @Getter @Setter @Column(name = "id_usu", nullable = false)
    private Long id;

    @Getter @Setter @Column(name="persona")
    private String name;

    @Getter @Setter @Column(name="nom_usu")
    private String user;

    @Getter @Setter @Column(name="contrasena_usu")
    private String password;

    @Getter @Setter @Column(name="id_tipo")
    private int id_type;

}
