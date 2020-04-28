package com.management.feeTraining.dao;

import com.management.feeTraining.entities.Role;
import com.management.feeTraining.entities.RoleType;

public interface RoleDao {

    Role findByName(RoleType name);
    void save(Role role);
}
