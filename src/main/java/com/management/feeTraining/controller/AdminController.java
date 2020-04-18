package com.management.feeTraining.controller;

import com.management.feeTraining.Services.AdminService;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class AdminController {


    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public List<Student> getAllStudents() {

        return adminService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(int studentId) {

        return adminService.getStudent(studentId);
    }

    @PostMapping("")
    public void createStudent(@Valid @RequestBody StudentDto student) {

        adminService.save(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@Valid @PathVariable() int sId) {
        adminService.deleteStudent(sId);
    }



}
