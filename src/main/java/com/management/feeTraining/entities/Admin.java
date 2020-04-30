package com.management.feeTraining.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="uId")
public class Admin extends User {

}
