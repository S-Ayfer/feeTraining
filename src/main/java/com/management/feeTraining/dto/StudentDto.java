package com.management.feeTraining.dto;

import com.management.feeTraining.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int fee;
    private int feePaid;
    private int due;

    private User user;
}
