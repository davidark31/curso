package com.cursoJava.curso.controllers;


import com.cursoJava.curso.dao.CargaDao;
import com.cursoJava.curso.models.Carga;
import com.cursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargasController {

    @Autowired
    private CargaDao cargaDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validateToken(String token){
        String idUser = jwtUtil.getKey(token);
        return idUser!=null;
    }

    @RequestMapping(value = "api/cargas",method = RequestMethod.GET)
    public List<Carga> getCargas(@RequestHeader(value = "Authorization") String token ) {
        if(validateToken(token)){
            return cargaDao.getCargas();
        }
        return null;
    }

}
