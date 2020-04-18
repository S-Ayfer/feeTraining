package com.management.feeTraining.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Menu> menus;
}
