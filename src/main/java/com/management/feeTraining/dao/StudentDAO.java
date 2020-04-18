package com.management.feeTraining.dao;

import com.management.feeTraining.entities.Student;

public interface StudentDAO {

    Student findById(Long id);
    void save(Student student);
    Student findByEmail(String email);


}
