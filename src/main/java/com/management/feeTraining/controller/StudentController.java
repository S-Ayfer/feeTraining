package com.management.feeTraining.controller;

import com.management.feeTraining.Services.StudentService;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/{studentId}")
    public Student getStudent(Long studentId) {

        return studentService.findById(studentId);
    }


    @PutMapping("/{sId}")
    public Student updateStudent(@PathVariable("sId") Long studentId, @RequestBody StudentDto studentDto ) {

        return studentService.updateStudent(studentId, studentDto);
    }

}
