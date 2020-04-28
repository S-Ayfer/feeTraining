package com.management.feeTraining.controller;

import com.management.feeTraining.Services.AccountantService;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/accountant")

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

    @PostMapping("/create")
    public void createStudent(@RequestBody StudentDto student) {

        accountantService.createStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable() int sId) {
        accountantService.deleteStudent(sId);
    }


}
