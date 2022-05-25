package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Carga;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class CargaDaoImp implements CargaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Carga> getCargas() {
        String query = "FROM Carga";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void register(Carga carga) {entityManager.merge(carga);}



}
