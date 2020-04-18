package com.management.feeTraining.Services;

import com.management.feeTraining.dao.AccountantDAO;
import com.management.feeTraining.dao.StudentDAO;
import com.management.feeTraining.dao.UserDAO;
import com.management.feeTraining.entities.Accountant;
import com.management.feeTraining.entities.Student;
import com.management.feeTraining.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private AccountantDAO accountantDAO;

    public User authenticateUser(User user) {
        User authUser = new User();

        if (user.getEmail().equals("admin") && user.getPassword().equals("admin")) {
            authUser.setId(1L);
            authUser.setEmail("admin@admin.com");

            userDAO.findAll().forEach(userdb -> {
                if (user.getEmail().equals(userdb.getEmail()) && user.getPassword().equals(userdb.getPassword())) {
                    authUser.setEmail(userdb.getEmail());
                    authUser.setRoles(userdb.getRoles());

                    Student student = studentDAO.findByEmail(userdb.getEmail());
                    Accountant accountant = accountantDAO.findByEmail(userdb.getEmail());

                    if (student == null && accountant != null) {
                        authUser.setId(accountant.getAId());
                    }else {
                        authUser.setId(student.getSId());
                    }
                }
            });
        }
        return authUser;
    }
}
