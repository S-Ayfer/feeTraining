package com.management.feeTraining.config;

import com.management.feeTraining.dao.RoleDao;
import com.management.feeTraining.dao.UserDao;
import com.management.feeTraining.entities.Role;
import com.management.feeTraining.entities.RoleType;
import com.management.feeTraining.entities.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DummyDataLoader {

    org.slf4j.Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private RoleDao roleDAO;
    @Autowired
    private UserDao userDAO;

    @Transactional
    void createRole(String roleName, String desc) {
        Role role = new Role();
        role.setName(RoleType.valueOf(roleName));
        role.setDescription(desc);
        roleDAO.save(role);
        }


    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        createRole("ADMIN","admin");
        createRole("USER", "user");
        createRole("ACCOUNTANT", "accountant");
        createRole("STUDENT", "student");


        User user = new User();
        user.setFirstName("Emre");
        user.setLastName("Yildiz");
        user.setUsername("admin");
        user.setPassword("pass");
        user.setRoles(Arrays.asList(roleDAO.findByName(RoleType.ADMIN)));
        user.setEnabled(true);
        userDAO.save(user);

        User user2 = new User();
        user2.setFirstName("Hasan");
        user2.setLastName("Yildiz");
        user2.setUsername("user");
        user2.setPassword("pass");
        user2.setRoles(Arrays.asList(roleDAO.findByName(RoleType.USER)));
        user2.setEnabled(true);
        userDAO.save(user2);

        User user3 = new User();
        user3.setFirstName("Halim");
        user3.setLastName("Yildiz");
        user3.setUsername("accountant");
        user3.setPassword("pass");
        user3.setRoles(Arrays.asList(roleDAO.findByName(RoleType.ACCOUNTANT)));
        user3.setEnabled(true);
        userDAO.save(user3);

        User user4 = new User();
        user4.setFirstName("Mehmet");
        user4.setLastName("Yildiz");
        user4.setUsername("student");
        user4.setPassword("pass");
        user4.setFee(1000);
        user4.setFeePaid(500);
        user4.setRoles(Arrays.asList(roleDAO.findByName(RoleType.ACCOUNTANT)));
        user4.setEnabled(true);
        userDAO.save(user4);

        User user5 = new User();
        user5.setFirstName("Dursun");
        user5.setLastName("Yildiz");
        user5.setUsername("dyildiz");
        user5.setEmail("dyildiz@gmail.com");
        user5.setFee(1000);
        user5.setFeePaid(300);
        user5.setPassword("pass");
        user5.setRoles(Arrays.asList(roleDAO.findByName(RoleType.STUDENT)));
        user5.setEnabled(true);
        userDAO.save(user5);

        User user6 = new User();
        user6.setFirstName("Tekin");
        user6.setLastName("Yildiz");
        user6.setUsername("dyildiz");
        user6.setEmail("tyildiz@gmail.com");
        user6.setFee(1000);
        user6.setFeePaid(700);
        user6.setPassword("pass");
        user6.setRoles(Arrays.asList(roleDAO.findByName(RoleType.STUDENT)));
        user6.setEnabled(true);
        userDAO.save(user6);
    }
}
