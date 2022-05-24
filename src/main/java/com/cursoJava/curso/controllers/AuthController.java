package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UserDao;
import com.cursoJava.curso.models.User;
import com.cursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String login(@RequestBody User user) {

        User userLoged= userDao.getUserByCredencials(user);

        if(userLoged!=null){
            String tokenJwt = jwtUtil.create(String.valueOf(userLoged.getId()),userLoged.getUser());
            return tokenJwt;
        }else{
            return "FAIL";
        }
    }
}