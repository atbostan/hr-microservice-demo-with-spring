package com.bossware.hr.application.exceptions.employee;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}