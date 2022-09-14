package com.bossware.hr.core.dto.response;

import com.bossware.hr.domain.annotations.DataTransferObject;
import com.bossware.hr.domain.valueObjects.Currency;
import com.bossware.hr.domain.valueObjects.Department;
import com.bossware.hr.domain.valueObjects.JobStyle;

import lombok.Data;


@DataTransferObject
@Data
public class EmployeeResponse {
	private String identity;
	private String firstName;
	private String lastName;
	private String iban;
	private double salary;
	private Currency currency;
	private int birthYear;
	private Department department;
	private JobStyle jobStyle;
	private String photo;
}
