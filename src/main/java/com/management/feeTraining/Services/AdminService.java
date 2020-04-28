package com.management.feeTraining.Services;

import com.management.feeTraining.dao.AdminDAO;
import com.management.feeTraining.dto.DtoBuilder;
import com.management.feeTraining.dto.UserDto;
import com.management.feeTraining.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<UserDto>();

        for (User user: adminDAO.getUsers()) {
            users.add(DtoBuilder.userToUserDTO(user));
        }

        return users;
    }

    public UserDto getUserById(int id) {
        User user = adminDAO.getUser(id);
        return DtoBuilder.userToUserDTO(user);
    }

    public void createUser(UserDto user) {
        adminDAO.createUser(DtoBuilder.userDTOToUser(user));
    }

    public void updateUser(UserDto user) {
        adminDAO.updateUser(DtoBuilder.userDTOToUser(user));

    }

    public void deleteUser(int id) {
        adminDAO.deleteUser(id);
    }

}
