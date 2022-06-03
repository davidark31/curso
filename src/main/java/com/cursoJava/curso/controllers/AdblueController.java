package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.AdblueDao;
import com.cursoJava.curso.models.Adblue;
import com.cursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdblueController {

    @Autowired
    private AdblueDao adblueDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validateToken(String token){
        String idUser = jwtUtil.getKey(token);
        return idUser!=null;
    }

    @RequestMapping(value = "api/adblue",method = RequestMethod.GET)
    public List<Adblue> getAdblue() {
        return adblueDao.getAdblue();
    }


}
