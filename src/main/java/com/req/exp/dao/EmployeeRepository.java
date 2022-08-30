package com.req.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.req.exp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findById(@Param("id")int id);
	
}
