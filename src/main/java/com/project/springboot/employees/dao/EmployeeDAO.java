package com.project.springboot.employees.dao;


import com.project.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(long Id);

    Employee save(Employee employee);

    void deleteById(long Id);

}
