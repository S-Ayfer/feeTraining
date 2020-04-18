package com.management.feeTraining.Services;

import com.management.feeTraining.dao.AdminDAO;
import com.management.feeTraining.dao.StudentDAO;
import com.management.feeTraining.dao.UserDAO;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Accountant;
import com.management.feeTraining.entities.Student;
import com.management.feeTraining.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StudentDAO studentDAO;


    public void save(StudentDto newStudent) {
        Student student = new Student();
        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());

        User s = new User();
        s.setEmail(student.getEmail());
        s.setPassword("123");

        userDAO.save(s);
        studentDAO.save(student);
    }

    public List<Student> getAllStudents() {
        return adminDAO.findAllStudent();
    }

    public void deleteStudent(int id) {
        adminDAO.deleteStudentById(id);
    }

    public Student getStudent(int id) {
        return adminDAO.findByIdStudent(id);
    }

    public void deleteAccountant(int id) {
        adminDAO.deleteStudentById(id);
    }

    public Accountant getAccountant(int id) {
        return adminDAO.findByIdAccountant(id);
    }

    public void saveAccountant(Accountant accountant) {
        adminDAO.saveAccountant(accountant);
    }


}
