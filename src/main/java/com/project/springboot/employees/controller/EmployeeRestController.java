package com.project.springboot.employees.controller;

import com.project.springboot.employees.entity.Employee;
import com.project.springboot.employees.request.EmployeeRequest;
import com.project.springboot.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest endpoints", description = "Operations related with employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @Operation(summary = "Get all employees from database", description = "Retrieve the list of employees from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Fetch single employee from database", description = "Retrieve the single employee form database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        return employee;
    }

    @Operation(summary = "Createa a new employee", description = "Add a new in the database")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee saveEmployee = employeeService.save(employeeRequest);
        return saveEmployee;
    }

    @Operation(summary = "Update a existing employee", description = "Update a existing employee from database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value = 1) long employeeId, @Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee modifyEmployee = employeeService.update(employeeId, employeeRequest);
        return modifyEmployee;
    }

    @Operation(summary = "Delete a single employee", description = "Delete a single employee from database")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId) {
        employeeService.deleteById(employeeId);
    }
}
