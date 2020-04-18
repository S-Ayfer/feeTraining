package com.management.feeTraining.Services;

import com.management.feeTraining.dao.StudentDAO;
import com.management.feeTraining.dao.UserDAO;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private UserDAO userDAO;



    public Student findById(Long id) {

        return studentDAO.findById(id);
    }


    public Student updateStudent(Long studentId, StudentDto student) {
        Student updateStudent = studentDAO.findById(studentId);

        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());

        studentDAO.save(updateStudent);
        return updateStudent;
    }
}