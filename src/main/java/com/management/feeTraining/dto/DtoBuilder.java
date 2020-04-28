package com.management.feeTraining.dto;

import com.management.feeTraining.entities.User;

public class DtoBuilder {

    public static UserDto userToUserDTO(User user) {
        return new UserDto(user.getId(), user.getName(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.getRoles());
    }
    public static User userDTOToUser(UserDto user) {
        return new User(user.getId(), user.getName(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.getRoles());
    }
}
