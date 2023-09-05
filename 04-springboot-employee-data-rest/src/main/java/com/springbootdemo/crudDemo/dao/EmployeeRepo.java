package com.springbootdemo.crudDemo.dao;

import com.springbootdemo.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
