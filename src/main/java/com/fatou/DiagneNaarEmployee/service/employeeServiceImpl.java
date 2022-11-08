package com.fatou.DiagneNaarEmployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatou.DiagneNaarEmployee.exception.ResourceNotFoundException;
import com.fatou.DiagneNaarEmployee.model.Employee;
import com.fatou.DiagneNaarEmployee.repository.EmployeeRepository;

@Service
public class employeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
	Optional<Employee>  Employee = repo.findById(id);
	if(Employee.isPresent()) {
		return Employee.get();
	}else {
		throw new ResourceNotFoundException("Employee","Id",id);
	}
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Employee existingEmployee = repo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee","Id",id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		repo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee","Id",id));
			repo.deleteById(id);
		
	}

}
