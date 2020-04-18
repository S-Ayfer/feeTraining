package com.management.feeTraining.dao;

import com.management.feeTraining.entities.User;

import java.util.List;

public interface UserDAO {

    void save(User user);
    List<User> findAll();
    User findByEmail(String email);
}
