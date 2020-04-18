package com.management.feeTraining.controller;

import com.management.feeTraining.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private com.management.feeTraining.Services.LoginService loginService;

    @PostMapping("/login")
    public User authenticate(@Validated @RequestBody User user) {

        return loginService.authenticateUser(user);
    }

}
