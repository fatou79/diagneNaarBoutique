package com.fatou.DiagneNaarEmployee.service;

import java.util.List;

import com.fatou.DiagneNaarEmployee.model.Employee;


public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long Id);
	Employee updateEmployee(Employee employee, Long id);
	void deleteEmployee(Long id);

}
