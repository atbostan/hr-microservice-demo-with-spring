package com.bossware.hr.core.configurations;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bossware.hr.core.dto.request.EmployeeRequest;
import com.bossware.hr.core.dto.response.EmployeeResponse;
import com.bossware.hr.core.entity.EmployeeEntity;
import com.bossware.hr.domain.Employee;

@Configuration
public class ModelMapperConfig {

	private static final Converter<Employee, EmployeeResponse> EMPLOYEE_TO_EMPLOYEE_RESPONSE = context -> {
		var response = new EmployeeResponse();
		var employee = context.getSource();
		response.setBirthYear(employee.getBirthYear().getValue());
		response.setCurrency(employee.getCurrency());
		response.setDepartment(employee.getDepartment());
		response.setFirstName(employee.getFullName().getFirstName());
		response.setIban(employee.getIban().getValue());
		response.setIdentity(employee.getIdentity().getValue());
		response.setJobStyle(employee.getJobStyle());
		response.setLastName(employee.getFullName().getLastName());
		response.setPhoto(employee.getPhoto().getBase64EncodedValues());
		response.setSalary(employee.getSalary().getValue());

		return response;

	};

	private static final Converter<Employee, EmployeeEntity> EMPLOYEE_TO_EMPLOYEE_ENTITY = context -> {
		var entity = new EmployeeEntity();
		var employee = context.getSource();
		entity.setIdentity(employee.getIdentity().getValue());
		entity.setFirstName(employee.getFullName().getFirstName());
		entity.setLastName(employee.getFullName().getLastName());
		entity.setIban(employee.getIban().getValue());
		entity.setSalary(employee.getSalary().getValue());
		entity.setCurrency(employee.getSalary().getCurrency());
		entity.setBirthYear(employee.getBirthYear().getValue());
		entity.setDepartment(employee.getDepartment());
		entity.setJobStyle(employee.getJobStyle());
		entity.setPhoto(employee.getPhoto().getValues());
		return entity;
	};

	private static final Converter<EmployeeRequest, Employee> HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE = context -> {
		var request = context.getSource();
		return new Employee.Builder(request.getIdentity()).fullName(request.getFirstName(), request.getLastName())
				.salary(request.getSalary(), request.getCurrency()).iban(request.getIban())
				.birthYear(request.getBirthYear()).photo(request.getPhoto()).department(request.getDepartment())
				.jobStyle(request.getJobStyle()).build();
	};

	private static final Converter<EmployeeEntity, Employee> EMPLOYEE_ENTITY_TO_EMPLOYEE = context -> {
		var entity = context.getSource();
		return new Employee.Builder(entity.getIdentity()).fullName(entity.getFirstName(), entity.getLastName())
				.salary(entity.getSalary(), entity.getCurrency()).iban(entity.getIban())
				.birthYear(entity.getBirthYear()).photo(entity.getPhoto()).department(entity.getDepartment())
				.jobStyle(entity.getJobStyle()).build();
	};

	@Bean
	public ModelMapper createModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_RESPONSE, Employee.class, EmployeeResponse.class);
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_ENTITY, Employee.class, EmployeeEntity.class);
		modelMapper.addConverter(HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE, EmployeeRequest.class, Employee.class);
		modelMapper.addConverter(EMPLOYEE_ENTITY_TO_EMPLOYEE, EmployeeEntity.class, Employee.class);
		return modelMapper;
	}
}
