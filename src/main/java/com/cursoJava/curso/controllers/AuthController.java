package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UserDao;
import com.cursoJava.curso.models.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private UserDao userDao;

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public void login(@RequestBody User user) {
        userDao.checkEmailPassword(user);
    }
}
