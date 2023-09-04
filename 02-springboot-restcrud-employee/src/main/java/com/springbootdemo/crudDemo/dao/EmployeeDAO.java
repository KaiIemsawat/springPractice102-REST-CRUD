package com.springbootdemo.crudDemo.dao;

import com.springbootdemo.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
