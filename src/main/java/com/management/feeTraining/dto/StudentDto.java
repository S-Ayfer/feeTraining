package com.management.feeTraining.dto;

import com.management.feeTraining.entities.Role;
import lombok.Data;

import java.util.Set;


@Data
public class StudentDto extends UserDto {

   private int fee;
   private int paidFee;
   private int due;
   private Set<Role> roles;

}
