package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Adblue;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class AdblueDaoImp implements AdblueDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Adblue> getAdblue() {
        String query = "from Adblue";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void register(Adblue adblue) {
        entityManager.merge(adblue);
    }
}
