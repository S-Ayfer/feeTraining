package com.management.feeTraining.controller;

import com.management.feeTraining.dto.UserDto;
import com.management.feeTraining.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getAllUser() {
//        return new ModelAndView().addObject("users", userService.getAllUsers());
        return userService.getAllUsers();
    }

    @GetMapping
    public ModelAndView showEditUserForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit-user");
        mav.addObject("users", userService.getAllUsers());
        return mav;
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
