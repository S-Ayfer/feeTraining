package com.management.feeTraining.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="uId")
public class Student extends User {

    private int fee;
    private int feePaid;
    private int due;
}
