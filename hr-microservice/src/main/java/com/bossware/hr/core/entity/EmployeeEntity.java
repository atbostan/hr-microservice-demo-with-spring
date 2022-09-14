package com.bossware.hr.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bossware.hr.application.validation.Iban;
import com.bossware.hr.application.validation.TcKimlikNo;
import com.bossware.hr.domain.valueObjects.Currency;
import com.bossware.hr.domain.valueObjects.Department;
import com.bossware.hr.domain.valueObjects.JobStyle;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class EmployeeEntity {
	@Id
	@TcKimlikNo
	private String identity;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Iban
	private String iban;
	
	@DecimalMin(value = "5500.0")
	private double salary;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Currency currency;
	
	@Min(1940)
	private int birthYear;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Department department;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private JobStyle jobStyle;
	
	@Lob
	@Column(name="img", columnDefinition = "longblob")
	@NotNull
	private byte[] photo;
}
