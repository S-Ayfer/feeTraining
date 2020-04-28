package com.management.feeTraining.dao;

import com.management.feeTraining.entities.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void save(User user);
    User getUserById(int id);
    void deleteUser(int id);
}
