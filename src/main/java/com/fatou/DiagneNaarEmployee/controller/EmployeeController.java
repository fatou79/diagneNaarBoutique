package com.fatou.DiagneNaarEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatou.DiagneNaarEmployee.model.Employee;
import com.fatou.DiagneNaarEmployee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

		
	
	// create an employee
	
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.OK);
		
	}
	
	//  get all employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	//get employee by id
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
		return new ResponseEntity<Employee>(service.getEmployeeById(id), HttpStatus.OK);
		
	}
	
	//update an employee
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")Long id,
			@RequestBody Employee employee){
		return new ResponseEntity<Employee>(service.updateEmployee(employee,id),HttpStatus.OK);
	}
	
	//delete an employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		service.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!.",HttpStatus.OK);
			
		}
		
}
	
	


