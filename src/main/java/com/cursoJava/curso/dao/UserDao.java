package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void delete(long id);
}
