package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UserDao;
import com.cursoJava.curso.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDao userDao;



    @RequestMapping(value = "api/users")
    public List<User> getUser() {
        List<User> users=new ArrayList<>();
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        User user = new User();
        user.setId(id);
        user.setName("David Rivas");
        user.setUser("drivas");
        user.setPassword("20340522");
        user.setId_type(1);
        return user;
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void delete (@PathVariable long id) {
        userDao.delete(id);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.PUT)
    public User edit () {
        User user = new User();
        return user;
    }

    }