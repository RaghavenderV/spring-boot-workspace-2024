package com.vodapally.repository;

import com.vodapally.dto.EmployeeDepartmentDTO;
import com.vodapally.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //JPQL Query to fetch all employees by department name
//    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
//    List<Employee> getEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    //JPA -> to fetch all employees by department name
//    List<Employee> getEmployeesByDepartmentName(String departmentName);

    //SQL Query to fetch all employees by department name
    @Query(value = "SELECT e.* FROM EMPLOYEE_IBS e JOIN DEPARTMENT d on e.department_id = d.id WHERE d.name = :departmentName", nativeQuery = true)
    List<Employee> getEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    // JPQL to fetch specific columns from employee
    @Query("SELECT new com.vodapally.dto.EmployeeDepartmentDTO(e.name, d.name) FROM Employee e JOIN e.department d  " +
            "WHERE d.name = :departmentName")
    List<EmployeeDepartmentDTO> getEmployeesByDepartmentNameCustomized(String departmentName);
    }
