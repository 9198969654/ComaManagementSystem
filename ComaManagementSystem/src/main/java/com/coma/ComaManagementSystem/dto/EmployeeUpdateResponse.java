package com.coma.ComaManagementSystem.dto;

import com.coma.ComaManagementSystem.entities.Employee;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateResponse {

    private String message;

    private Employee employee;

}
