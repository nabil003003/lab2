package com.example.jpa.dao;

import com.example.jpa.entities.Salle;
import javax.persistence.EntityManager;
import java.util.List;

public class SalleDao extends GenericDao<Salle> {

    public SalleDao(EntityManager em) {
        super(Salle.class, em);
    }

    public List<Salle> findByCapaciteMin(int capaciteMin) {
        return em.createQuery("SELECT s FROM Salle s WHERE s.capaciteS >= :capaciteMin", Salle.class)
                .setParameter("capaciteMin", capaciteMin)
                .getResultList();
    }

    public List<Salle> findByCapaciteMax(int capaciteMax) {
        return em.createQuery("SELECT s FROM Salle s WHERE s.capaciteS <= :capaciteMax", Salle.class)
                .setParameter("capaciteMax", capaciteMax)
                .getResultList();
    }
}
