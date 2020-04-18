package com.management.feeTraining.dao;

import com.management.feeTraining.entities.Accountant;
import com.management.feeTraining.entities.Student;

import java.util.List;

public interface AdminDAO {

    List<Accountant> findAllAccountant();
    List<Student> findAllStudent();
    Accountant findByIdAccountant(int id);
    Student findByIdStudent(int id);

    void saveAccountant(Accountant accountant);
    void saveStudent(Student student);

    void deleteAccountantById(int id);
    void deleteStudentById(int id);

}
