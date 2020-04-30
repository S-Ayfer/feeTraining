package com.management.feeTraining.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private RoleType name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Menu> menus;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {}

    public Role(RoleType name, String description) {
        this.name = name;
    }

    public Role(int id, RoleType name, String description, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
