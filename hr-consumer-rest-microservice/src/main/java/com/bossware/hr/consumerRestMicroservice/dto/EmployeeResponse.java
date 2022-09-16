package com.bossware.hr.consumerRestMicroservice.dto;

import lombok.Data;

@Data
public class EmployeeResponse {
	private String identity;
	private String firstName;
	private String lastName;
	private String iban;
	private double salary;
	private String currency;
	private int birthYear;
	private String department;
	private String jobStyle;
	private String photo;
	
}
