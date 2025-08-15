package com.project.springboot.employees.dao;

import com.project.springboot.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(long Id) {
        Employee findEmployee = entityManager.find(Employee.class , Id);
        return findEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee saveEmployee = entityManager.merge(employee);
        return saveEmployee;
    }

    @Override
    public void deleteById(long Id) {
        Employee deleteEmployee = entityManager.find(Employee.class , Id);
        entityManager.remove(deleteEmployee);
    }


}
