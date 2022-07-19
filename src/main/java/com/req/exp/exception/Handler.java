package com.req.exp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Map<String,String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		Map<String,String> hm=new HashMap<>();
		hm.put("errorMessage", ex.getMessage());
		return hm;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Map<String,String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
		Map<String, String> hm=new HashMap<>();
		hm.put("error", ex.getMessage());
		hm.put("caution", "Check whether you are passing the required parameters");
		return hm;
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	Map<String, String> hm=new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error->{
    hm.put(error.getField(), error.getDefaultMessage());
    });
    return hm;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> EmployeeNotFoundException(EmployeeNotFoundException ex){
		Map<String, String> hm=new HashMap<>();
		hm.put("errorMessage", ex.getMessage());
		return hm;
	}
	
}
