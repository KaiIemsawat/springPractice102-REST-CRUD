package com.springbootdemo.crudDemo.restCtrl;

import com.springbootdemo.crudDemo.entity.Employee;
import com.springbootdemo.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    add mapping for GET "/employees/{employeeId}
    @GetMapping("/employees/{employeeId}") // {thisValue} == @PathVariable int thisValue
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw  new RuntimeException("Employee id " + employeeId + " not found" );
        }
        return theEmployee;
    }

//    add mapping for POST "/employees" - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        /**
        NOTE !  We set the id to 0 to force JPA/Hibernate to add/insert a new entry to the database.
        Based on JPA logic, if id==0 then it will perform an add/insert in the database as opposed to an update.
        We add this because for the case of "add", the user may mistakenly send over a non-zero value in
        the JSON and this is not the desired data.
         **/
        Employee dbEmployee = employeeService.save(theEmployee); // save update
        return  dbEmployee; // return updated employee
    }

//    update mapping for PUT "/employees"
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
/**
        In theis case, we need to give an id in Postman to give a specific employee needed to update
        For example,
        {
            "id": 1,
                "firstName": "Titann",
                "lastName": "Iem",
                "email": "titann@email.com"
        }
 **/
    }

//    add mapping for delete an employee by id "/employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

//        Throw exception if not found
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id " + employeeId + "not found");
        }

        employeeService.deleteById(employeeId);

        return "Employee id " + employeeId + " is removed";
    }

}
