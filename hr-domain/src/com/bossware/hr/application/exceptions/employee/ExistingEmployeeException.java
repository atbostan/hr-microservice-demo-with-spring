package com.bossware.hr.application.exceptions.employee;

@SuppressWarnings("serial")
public class ExistingEmployeeException extends RuntimeException {

	public ExistingEmployeeException(String message) {
		super(message);
	}

}
