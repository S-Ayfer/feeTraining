package com.management.feeTraining.dao;

import com.management.feeTraining.dto.StudentDto;
import com.management.feeTraining.entities.Student;

public interface StudentDAO {

    StudentDto findById(Long id);
    void save(StudentDto student);
    Student findByEmail(String email);


}
