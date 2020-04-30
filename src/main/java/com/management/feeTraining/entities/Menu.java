package com.management.feeTraining.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "menus")
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private MenuType name;

    @ManyToOne
    @JoinColumn(name = "fk_role_id", nullable = false)
    private Role role;

}
