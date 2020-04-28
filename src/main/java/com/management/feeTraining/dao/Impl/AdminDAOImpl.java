package com.management.feeTraining.dao.Impl;

import com.management.feeTraining.dao.AdminDAO;
import com.management.feeTraining.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory sf;

    @PersistenceContext
    EntityManager em;

    public Session getSession() {
        Session session = sf.getCurrentSession();
        if (session == null) {
            sf.openSession();
        }
        return session;
    }

    @Override
    public List<User> getUsers() {
        return em.createQuery("From User", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return getSession().get(User.class, id);
    }

    @Override
    public void createUser(User user) {
        getSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public void deleteUser(int id) {

    }
}
