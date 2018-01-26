package com.taskombank.gerasimenko.service.impl;

import com.taskombank.gerasimenko.entity.Client;
import com.taskombank.gerasimenko.service.ClientServiceDAO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ClientServiceDAOImpl implements ClientServiceDAO {
    protected EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Client> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Client", Client.class).getResultList();
    }

    @Override
    public Client getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Client.class, id);
    }

    @Override
    public Client getByName(@NotNull final String name) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Client where name = :name", Client.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public Client saveOrUpdate(Client client) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Client savedClient = em.merge(client);
        em.getTransaction().commit();

        return savedClient;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Client.class, id));
        em.getTransaction().commit();
    }
}
