package com.management.feeTraining.dao.Impl;

import com.management.feeTraining.dao.AdminDAO;
import com.management.feeTraining.entities.Accountant;
import com.management.feeTraining.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {

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
    public List<Accountant> findAllAccountant() {
        return getSession().createQuery("From Accountant",Accountant.class)
                .getResultList();
    }

    @Override
    public List<Student> findAllStudent() {
        Query<Student> query = getSession().createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Accountant findByIdAccountant(int id) {

        return getSession().get(Accountant.class,id);
    }

    @Override
    public Student findByIdStudent(int id) {

        return getSession().get(Student.class,id);
    }
    @Override
    public void saveAccountant(Accountant accountant) {
        getSession().saveOrUpdate(accountant);
    }

    @Override
    public void saveStudent(Student student) {
        getSession().saveOrUpdate(student);
    }

    @Override
    public void deleteAccountantById(int id) {

        getSession().createQuery("DELETE FROM Accountant WHERE id=:idToDelete")
                .setParameter("idToDelete", id).executeUpdate();
    }
    @Override
    public void deleteStudentById(int id) {

        getSession().createQuery("DELETE FROM Student WHERE id=:idToDelete")
                .setParameter("idToDelete", id).executeUpdate();
    }

}
