package com.bossware.hr.presentation.handler;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bossware.hr.application.exceptions.employee.EmployeeNotFoundException;
import com.bossware.hr.application.exceptions.employee.ExistingEmployeeException;
import com.bossware.hr.core.dto.exception.ErrorMessage;
import com.bossware.hr.core.dto.exception.ExceptionTypes;

@RestControllerAdvice
public class RestApiErrorHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e){
		return e.getConstraintViolations()
				.stream()
				.map(er->new ErrorMessage(e.getMessage(),ExceptionTypes.VALIDATION_EXCEPTION.name()
						,HttpStatus.BAD_REQUEST.ordinal(),null)).toList();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		return e.getAllErrors()
				.stream()
				.map(er->new ErrorMessage(e.getMessage(),ExceptionTypes.VALIDATION_EXCEPTION.name()
						,HttpStatus.BAD_REQUEST.ordinal(),null)).toList();
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleEmployeeNotFoundException(EmployeeNotFoundException e){
		return  new ErrorMessage(e.getMessage(),ExceptionTypes.NOT_FOUND.name() ,HttpStatus.BAD_REQUEST.ordinal(),null);
	}
	
	@ExceptionHandler(ExistingEmployeeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleExistingEmployeeException(ExistingEmployeeException e){
		return  new ErrorMessage(e.getMessage(),ExceptionTypes.EXISTING_RECORD.name() ,HttpStatus.BAD_REQUEST.ordinal(),null);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ErrorMessage handleException(Exception e) {
		return new ErrorMessage(e.getMessage(),ExceptionTypes.API_EXCEPTION.name(),HttpStatus.BAD_GATEWAY.ordinal(),null);                         
	}
}
