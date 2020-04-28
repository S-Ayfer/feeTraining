package com.management.feeTraining.entities;

import com.management.feeTraining.dto.UserDto;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min=3, max=8)
    private String password;

    @NaturalId
    @NotBlank
    private String email;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {}



    public UserDto userDto() {
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setEmail(email);
        userDto.setName(name);
        userDto.setPassword(password);
        userDto.setUsername(username);
        return userDto;
    }

    public User(int id, @NotBlank String name, @NotBlank String username, @NotBlank @Size(min = 3, max = 8) String password, @NotBlank String email, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
