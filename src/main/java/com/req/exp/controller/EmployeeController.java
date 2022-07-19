package com.req.exp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.req.exp.dto.EmployeeRequest;
import com.req.exp.exception.EmployeeNotFoundException;
import com.req.exp.model.Employee;
import com.req.exp.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

//	{
//	    "name":"dfg",
//		 "age":34,
//		 "salary":154334,
//		 "email":"asjd@gmail.com",
//		 "mobile":123456,
//		"nationality":null
//	}
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeRequest request) {
		return new ResponseEntity<>(service.addEmp(request), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getByid(@PathVariable int id) throws EmployeeNotFoundException {
		return ResponseEntity.ok(service.getById(id));
	}

}
