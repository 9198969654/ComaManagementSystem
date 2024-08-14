package com.coma.ComaManagementSystem.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Integer id) {
        super("Employee with ID " + id + " not found");
    }
}