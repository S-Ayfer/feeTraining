package com.management.feeTraining.services;

import com.management.feeTraining.dao.UserDao;
import com.management.feeTraining.dto.UserDto;
import com.management.feeTraining.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: userDao.getAllUsers()) {
            userDtos.add(user.toUserDto());
        }
       return userDtos;
    }

    public void updateUser(int id, UserDto userdto) {
        User user = userdto.toUser();
        user.setId(id);
        userDao.save(user);
    }

    public void save(UserDto userDto) {
        User user = userDto.toUser();
        userDao.save(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
