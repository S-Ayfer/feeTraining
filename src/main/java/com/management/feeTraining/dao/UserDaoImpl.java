package com.management.feeTraining.dao;

import com.management.feeTraining.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private static final Logger Logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sf;

    @Autowired
    private EntityManagerFactory emf;

    public Session getSession() {
        Session session = sf.getCurrentSession();
        if (session == null) {
            sf.openSession();
        }
        return session;
    }
    @Override
    public List<User> getAllUsers() {
        return getSession().createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public User getUserById(int id) {
        return (User) getSession().createQuery("From User u where u.id =:id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void deleteUser(int id) {
        User user = getSession().get(User.class, id);
        getSession().delete(user);
    }
}
