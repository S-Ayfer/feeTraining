package com.management.feeTraining.dao;

import com.management.feeTraining.entities.Student;

import java.util.List;

public interface AccountantDAO {

    List<Student> findAll();
    Student findById(int id);
    void save(Student student);
    void deleteById(int id);
}
