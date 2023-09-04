package com.springbootdemo.crudDemo.restCtrl;

import com.springbootdemo.crudDemo.entity.Employee;
import com.springbootdemo.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeCtrl {

    private EmployeeService employeeService;

//    Inject employee dao
    @Autowired
    public EmployeeCtrl(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

//    expose "/emplouees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
