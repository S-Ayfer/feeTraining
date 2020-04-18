package com.management.feeTraining.Services;

import com.management.feeTraining.dao.AccountantDAO;
import com.management.feeTraining.dao.UserDAO;
import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountantService {

    @Autowired
    private AccountantDAO accountantDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Student> getAllStudents() {

        return accountantDAO.findAll();
    }

    public Student getStudent(int id) {
        return accountantDAO.findById(id);
    }

    public void createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());

        accountantDAO.save(student);
    }

    public void deleteStudent(int id) {
        accountantDAO.deleteById(id);
    }
}
