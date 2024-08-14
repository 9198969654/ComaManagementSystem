package com.coma.ComaManagementSystem.service.impl;

import com.coma.ComaManagementSystem.dto.EmployeeUpdateResponse;
import com.coma.ComaManagementSystem.entities.Employee;
import com.coma.ComaManagementSystem.exception.EmployeeNotFoundException;
import com.coma.ComaManagementSystem.repositories.EmployeeRepository;
import com.coma.ComaManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        Employee employee1 = findEmployeeById(id);

        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        employee1.setDesignation(employee.getDesignation());

        return employeeRepository.save(employee1);


    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
