package com.springbootdemo.crudDemo.dao;

import com.springbootdemo.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{
//    Field for Entitymanager
    private EntityManager entityManager;

    /* Setup constructor injection */
    @Autowired
//                         Constructor injection
    public EmployeeDaoImpl(EntityManager theEntityManager) {
//                         Automatically created by Spring Boot
        entityManager = theEntityManager;
    }

    /* Find all employees */
    @Override
    public List<Employee> findAll() {
//        Create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
//        Execute query and get the results
        List<Employee> employees = query.getResultList();
//        return the results
        return employees;
    }

    /* Find employee by id */
    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    /* Save or update employee */
    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    /* Delete employee */
    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}