package com.management.feeTraining.controller;

import com.management.feeTraining.Services.AccountantService;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class AccountantController {

    @Autowired
    private AccountantService accountantService;


    @GetMapping("/")
    public List<Student> getAllStudents() {

        return accountantService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(int studentId) {

        return accountantService.getStudent(studentId);
    }

    @PostMapping("")
    public void createStudent(@Valid @RequestBody StudentDto student) {

        accountantService.createStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@Valid @PathVariable() int sId) {
        accountantService.deleteStudent(sId);
    }


}
