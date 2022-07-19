package com.req.exp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	Map<String, String> hm=new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error->{
    hm.put(error.getField(), error.getDefaultMessage());
    });
    return hm;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> EmployeeNotFoundException(EmployeeNotFoundException ex){
		Map<String, String> hm=new HashMap<>();
		hm.put("errorMessage", ex.getMessage());
		return hm;
	}
	
}
