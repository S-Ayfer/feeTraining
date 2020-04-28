package com.management.feeTraining.dao;

import com.management.feeTraining.dto.UserDto;
import com.management.feeTraining.entities.User;

import java.util.List;

public interface UserDAO {

    void save(User user);
    List<User> findAll();
    UserDto findByEmail(String email);
}
