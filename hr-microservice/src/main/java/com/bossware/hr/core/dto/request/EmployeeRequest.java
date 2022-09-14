package com.bossware.hr.core.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bossware.hr.application.validation.Iban;
import com.bossware.hr.application.validation.TcKimlikNo;
import com.bossware.hr.domain.valueObjects.Currency;
import com.bossware.hr.domain.valueObjects.Department;
import com.bossware.hr.domain.valueObjects.JobStyle;

import lombok.Data;

@Data
public class EmployeeRequest {
	@TcKimlikNo
	private String identity;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Iban
	private String iban;
	@Min(5_500)
	private double salary;
	@NotNull
	private Currency currency;
	@Min(1940)
	private int birthYear;
	@NotNull
	private Department department;
	@NotNull
	private JobStyle jobStyle;
	@NotBlank
	private String photo;
}
