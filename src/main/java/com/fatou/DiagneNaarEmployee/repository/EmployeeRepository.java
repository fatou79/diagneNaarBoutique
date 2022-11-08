package com.fatou.DiagneNaarEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatou.DiagneNaarEmployee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
