package com.management.feeTraining.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long role_id;

    @Enumerated(EnumType.STRING)
    private RoleType role_type;

    @ManyToMany(mappedBy = "roles")
    List<User> users;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Menu> menus;
}
