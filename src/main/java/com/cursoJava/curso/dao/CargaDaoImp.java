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

    @Transactional
    public List<Carga> getCargasData() {
        String query = "SELECT c.id_carga, c.patente, c.nro_bus, c.kil_ini, c.kil_act, c.litros_carg, c.fecha, c.costo, con.nombre_conductor, u.persona from carga c,conductor con, usuario u ";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void register(Carga carga) {entityManager.merge(carga);}



}
