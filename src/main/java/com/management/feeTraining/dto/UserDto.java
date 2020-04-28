package com.management.feeTraining.dto;

import com.management.feeTraining.entities.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Set<Role> roles;

    public UserDto(int id, String name, String username, String password, String email, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public UserDto() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
