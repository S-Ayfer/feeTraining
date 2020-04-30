package com.management.feeTraining.dto;

import com.management.feeTraining.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private boolean enabled;
    private int fee;
    private int feePaid;
    private int due;
    private List<String> roles;

    public User toUser() {
        User user = new User();
        user.setId(this.id);
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setDob(this.dob);
        user.setFee(this.fee);
        user.setFeePaid(this.feePaid);
        user.setDue(this.due);
        return user;
    }

}
