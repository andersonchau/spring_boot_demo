package com.and.demo.webappall.mongo.repository;

import com.and.demo.webappall.mongo.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllActiveEmployee();
    public void updateEmployee();

}
