package com.management.feeTraining.dao.Impl;

import com.management.feeTraining.dao.StudentDAO;
import com.management.feeTraining.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

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
    public Student findById(Long id) {

        return getSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {

        getSession().saveOrUpdate(student);
    }

    @Override
    public Student findByEmail(String email) {
        return getSession().get(Student.class,email);
    }


}