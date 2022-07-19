package com.req.exp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.req.exp.dao.EmployeeRepository;
import com.req.exp.dto.EmployeeRequest;
import com.req.exp.exception.EmployeeNotFoundException;
import com.req.exp.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;

	public Employee addEmp(EmployeeRequest request) {
		Employee emp = Employee.build(0, request.getName(), request.getAge(), request.getSalary(), request.getEmail(),
				request.getMobile(), request.getNationality());
		return repo.save(emp);
	}

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public Employee getById(int id) throws EmployeeNotFoundException  {
		Employee employee = repo.findById(id);
		if (employee != null) {
			return employee;
		}else{
			throw new  EmployeeNotFoundException("Employee not found with id: "+id);
	}
	}
	
	public Employee updateEmployee(int id,EmployeeRequest req) throws EmployeeNotFoundException {
		Employee e=repo.findById(id);
		if(e!=null) {
		Employee update=e.build(id, req.getName(),
					req.getAge(), req.getSalary(), req.getEmail(), 
					req.getMobile(), req.getNationality());
		return repo.save(update);
		
		}else {
			throw new EmployeeNotFoundException("Employee id: "+id+" not found");
		}
	}
	
	public String deleteEmp(int id) throws EmployeeNotFoundException {
		Employee e=repo.findById(id);
		if(e!=null) {
			repo.delete(e);
			return "Success";
		}else {
			throw new EmployeeNotFoundException("Employee id: "+id+" not found");
		}
	}
}
