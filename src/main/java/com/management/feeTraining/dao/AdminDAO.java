package com.management.feeTraining.dao;

import com.management.feeTraining.entities.User;

import java.util.List;

public interface AdminDAO {

    public List<User> getUsers();
    public User getUser(int id);
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);

}
