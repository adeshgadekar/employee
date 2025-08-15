package com.project.springboot.employees.service;

import com.project.springboot.employees.entity.Employee;
import com.project.springboot.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long Id);

    Employee save(EmployeeRequest employeeRequest);

    Employee update(long Id , EmployeeRequest employeeRequest);

    Employee convertToEmployee(long Id , EmployeeRequest employeeRequest);

    void deleteById(long Id);
}
