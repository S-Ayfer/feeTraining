package com.management.feeTraining.entities;

import javax.persistence.*;

@Entity
public class Student  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int fee;
    private int feePaid;
    private int due;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
