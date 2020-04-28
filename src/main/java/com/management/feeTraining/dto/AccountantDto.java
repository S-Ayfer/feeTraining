package com.management.feeTraining.dto;

import com.management.feeTraining.entities.Role;
import lombok.Data;

import java.util.Set;

@Data
public class AccountantDto extends UserDto{

    private Set<Role> roles;

    public AccountantDto(Set<Role> roles) {
        this.roles = roles;
    }

}