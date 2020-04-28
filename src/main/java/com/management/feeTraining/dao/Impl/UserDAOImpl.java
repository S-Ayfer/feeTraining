package com.management.feeTraining.dao.Impl;

import com.management.feeTraining.dao.UserDAO;
import com.management.feeTraining.dto.UserDto;
import com.management.feeTraining.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sf;

    public Session getSession() {
        Session session = sf.getCurrentSession();
        if (session == null) {
            sf.openSession();
        }
        return session;
    }

    @Override
    public void save(User user) {

        getSession().saveOrUpdate(user);
    }

    @Override
    public List<User> findAll() {

        return getSession().createQuery("FROM User", User.class).getResultList();
    }
    @Override
    public UserDto findByEmail(String email){
        return getSession().get(UserDto.class,email);

    }


}
