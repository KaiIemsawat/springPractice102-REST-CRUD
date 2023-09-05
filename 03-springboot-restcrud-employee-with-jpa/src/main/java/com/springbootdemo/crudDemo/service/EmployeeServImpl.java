package com.springbootdemo.crudDemo.service;

import com.springbootdemo.crudDemo.dao.EmployeeRepo;
import com.springbootdemo.crudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServImpl(EmployeeRepo theEmployeeRepo) {
        employeeRepo = theEmployeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);
        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find the employee : " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }

}
