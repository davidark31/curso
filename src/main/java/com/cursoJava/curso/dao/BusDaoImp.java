package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Bus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BusDaoImp implements BusDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Bus> getBuses() {
        String query = "from Bus";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void register(Bus bus) {entityManager.merge(bus);}
}
