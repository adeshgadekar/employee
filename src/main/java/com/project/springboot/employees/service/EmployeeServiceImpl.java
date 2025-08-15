package com.project.springboot.employees.service;

import com.project.springboot.employees.dao.EmployeeDAO;
import com.project.springboot.employees.entity.Employee;
import com.project.springboot.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(long Id) {
        return employeeDAO.findById(Id);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        Employee saveEmployee = convertToEmployee(0 , employeeRequest);
        return employeeDAO.save(saveEmployee);
    }

    @Transactional
    @Override
    public Employee update(long Id, EmployeeRequest employeeRequest) {
        Employee updateEmployee = convertToEmployee(Id , employeeRequest);
        return employeeDAO.save(updateEmployee);
    }

    @Override
    public Employee convertToEmployee(long Id, EmployeeRequest employeeRequest) {
        return new Employee(Id , employeeRequest.getFirstName(), employeeRequest.getLastName(),employeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long Id) {
        employeeDAO.deleteById(Id);
    }


}
