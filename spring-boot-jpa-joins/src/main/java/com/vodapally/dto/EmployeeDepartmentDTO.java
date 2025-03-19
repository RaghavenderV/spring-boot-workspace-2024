package com.vodapally.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDepartmentDTO {
    private String employeeName;
    private String departmentName;
}

/*
If you want to fetch specific columns (e.g., employee name and department name),
you can use a DTO (Data Transfer Object) and a custom query.
 */
