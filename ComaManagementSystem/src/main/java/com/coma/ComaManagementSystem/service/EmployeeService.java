package com.coma.ComaManagementSystem.service;

import com.coma.ComaManagementSystem.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee , Integer id);
    void deleteEmployee(Integer id);

}
