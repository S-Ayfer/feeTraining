package com.management.feeTraining.dao;

import com.management.feeTraining.entities.Role;
import com.management.feeTraining.entities.RoleType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

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
    public Role findByName(RoleType name) {
        return (Role) getSession().createQuery("from Role r where r.name =:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void save(Role role) {
        getSession().save(role);
    }
}
