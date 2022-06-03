package com.cursoJava.curso.controllers;

import com.cursoJava.curso.dao.BusDao;
import com.cursoJava.curso.models.Bus;
import com.cursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusesController {

    @Autowired
    private BusDao busDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validateToken(String token){
        String idUser = jwtUtil.getKey(token);
        return idUser!=null;
    }

    @RequestMapping(value = "api/buses",method = RequestMethod.GET)
    public List<Bus> getBuses() {
        return busDao.getBuses();

    }
}
