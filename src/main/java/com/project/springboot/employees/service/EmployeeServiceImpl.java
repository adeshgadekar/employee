package com.project.springboot.employees.service;

import com.project.springboot.employees.dao.EmployeeRepository;
import com.project.springboot.employees.entity.Employee;
import com.project.springboot.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long Id) {
        Optional <Employee> result = employeeRepository.findById(Id);
        Employee  employee;
        if(result.isPresent()){
            employee =  result.get();
        }
        else {
            throw new RuntimeException("Employee with " + Id +" not found in records");
        }
        return employee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        Employee saveEmployee = convertToEmployee(0 , employeeRequest);
        return employeeRepository.save(saveEmployee);
    }

    @Transactional
    @Override
    public Employee update(long Id, EmployeeRequest employeeRequest) {
        Employee updateEmployee = convertToEmployee(Id , employeeRequest);
        return employeeRepository.save(updateEmployee);
    }

    @Override
    public Employee convertToEmployee(long Id, EmployeeRequest employeeRequest) {
        return new Employee(Id , employeeRequest.getFirstName(), employeeRequest.getLastName(),employeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long Id) {
        employeeRepository.deleteById(Id);
    }


}
