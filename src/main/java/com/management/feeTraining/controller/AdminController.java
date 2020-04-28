package com.management.feeTraining.controller;

import com.management.feeTraining.Services.AdminService;
import com.management.feeTraining.Services.UserService;
import com.management.feeTraining.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> user = adminService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        UserDto user = adminService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        try {
            adminService.createUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpServerErrorException.InternalServerError u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="")
    public ResponseEntity<UserDto> update(@RequestBody UserDto user) {
        try {
            adminService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpServerErrorException.InternalServerError u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="{id}" )
    public ResponseEntity<UserDto> delete(@PathVariable int id) {
        try {
            adminService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpServerErrorException.InternalServerError u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
