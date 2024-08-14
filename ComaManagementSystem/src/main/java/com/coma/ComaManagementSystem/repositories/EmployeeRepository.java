package com.coma.ComaManagementSystem.repositories;

import com.coma.ComaManagementSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
