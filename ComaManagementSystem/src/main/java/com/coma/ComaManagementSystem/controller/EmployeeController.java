package com.coma.ComaManagementSystem.controller;

import com.coma.ComaManagementSystem.entities.Employee;
import com.coma.ComaManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employee =  employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> getAllEmployee = employeeService.getAllEmployees();
        return new ResponseEntity<>(getAllEmployee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id){
       Employee employee1  =  employeeService.updateEmployee(employee, id);
       return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Delete Successfully", HttpStatus.OK);
    }
}
