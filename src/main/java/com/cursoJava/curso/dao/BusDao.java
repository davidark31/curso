package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Bus;

import java.util.List;

public interface BusDao {

    List<Bus> getBuses();

    void register(Bus bus);
}
