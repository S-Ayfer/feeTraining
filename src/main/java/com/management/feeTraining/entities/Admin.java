package com.management.feeTraining.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="admins")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )

    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
