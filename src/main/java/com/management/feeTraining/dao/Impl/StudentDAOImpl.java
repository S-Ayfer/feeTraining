package com.management.feeTraining.dao.Impl;

import com.management.feeTraining.dao.StudentDAO;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
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
    public StudentDto findById(Long id) {

        return getSession().get(StudentDto.class, id);
    }

    @Override
    public void save(StudentDto student) {

        getSession().saveOrUpdate(student);
    }

    @Override
    public Student findByEmail(String email) {
        return getSession().get(Student.class,email);
    }


}