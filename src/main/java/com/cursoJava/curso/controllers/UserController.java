package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UserDao;
import com.cursoJava.curso.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public List<User> getUser() {
        List<User> users=new ArrayList<>();
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/users",method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        userDao.register(user);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        userDao.delete(id);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.PUT)
    public User edit () {
        User user = new User();
        return user;
    }

    }