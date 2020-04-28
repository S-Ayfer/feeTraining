package com.management.feeTraining.dao.Impl;

import com.management.feeTraining.dao.AccountantDAO;
import com.management.feeTraining.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountantDAOImpl implements AccountantDAO {

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
    public List<Student> findAll() {
        Query<Student> query = getSession().createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {

        return getSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {

        getSession().saveOrUpdate(student);
    }

    @Override
    public void deleteById(int id) {
        getSession().createQuery("DELETE FROM Accountant WHERE id=:id_del")
        .setParameter("id_del", id)
        .executeUpdate();
    }

}
