package com.vodapally;

import com.vodapally.entity.department.Department;
import com.vodapally.entity.employee.Employee;
import com.vodapally.repository.department.DepartmentRepository;
import com.vodapally.repository.employee.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootMysqlMultipleDsApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@PostConstruct
	public void initDBRecords() {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Raghu", "HR", 50000.0, "john@example.com", 30));
		employees.add(new Employee("Akshay", "IT", 60000.0, "jane@example.com", 35));
		employeeRepository.saveAll(employees);

		List<Department> departments = new ArrayList<>();
		departments.add(new Department("Finance", "John Doe"));
		departments.add(new Department("Human Resources", "Jane Smith"));
		departments.add(new Department("Marketing", "Alice Johnson"));
		departments.add(new Department("Engineering", "Bob Williams"));
		departments.add(new Department("Sales", "Eva Brown"));
		departmentRepository.saveAll(departments);

	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlMultipleDsApplication.class, args);
	}

}
