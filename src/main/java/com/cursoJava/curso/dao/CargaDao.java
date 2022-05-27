package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Carga;

import java.util.List;

public interface CargaDao {

    List<Carga> getCargas();

    List<Carga> getCargasData();

    void register(Carga carga);
}
