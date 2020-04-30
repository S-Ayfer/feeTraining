package com.management.feeTraining.controller;

import com.management.feeTraining.dto.UserDto;
import com.management.feeTraining.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getAllUser() {
        return userService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
