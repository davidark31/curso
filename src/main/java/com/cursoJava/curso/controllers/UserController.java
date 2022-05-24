package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.UserDao;
import com.cursoJava.curso.models.User;

import com.cursoJava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validateToken(String token){
        String idUser = jwtUtil.getKey(token);
        return idUser!=null;
    }

    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public List<User> getUser(@RequestHeader(value = "Authorization") String token ) {
         if(validateToken(token)){
          return userDao.getUsers();
         }
       return null;
    }

    @RequestMapping(value = "api/users",method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);
        userDao.register(user);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value = "Authorization") String token,@PathVariable long id) {
        if(validateToken(token)) {
            userDao.delete(id);
        }
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.PUT)
    public User edit (@RequestHeader(value = "Authorization") String token) {
        User user = new User();
        return user;
    }

}