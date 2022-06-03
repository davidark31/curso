package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Adblue;

import java.util.List;

public interface AdblueDao {

    List<Adblue> getAdblue();
    void register(Adblue adblue);
}
