package com.bossware.hr.application.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bossware.hr.application.HrApplication;
import com.bossware.hr.application.exceptions.employee.EmployeeNotFoundException;
import com.bossware.hr.core.dto.request.EmployeeRequest;
import com.bossware.hr.core.dto.response.EmployeeResponse;
import com.bossware.hr.domain.Employee;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

@Service
public class HrService {
	private final HrApplication hrApp;
	private final ModelMapper mapper;
	public HrService(HrApplication hrApp, ModelMapper mapper) {
		this.hrApp = hrApp;
		this.mapper = mapper;
	}
	
	public EmployeeResponse findEmployeeByIdentity(String identity) {
		Employee employeeFound = hrApp.getEmployee(TcKimlikNo.of(identity))
				                 .orElseThrow( () -> new EmployeeNotFoundException(identity));
		return mapper.map(employeeFound, EmployeeResponse.class);
	}

	@Transactional
	public EmployeeResponse hireEmployee(EmployeeRequest request) {
		var employee = mapper.map(request, Employee.class);
		var persistedEmployee = hrApp.hireEmployee(employee);
		return mapper.map(persistedEmployee, EmployeeResponse.class);
	}

	@Transactional
	public EmployeeResponse fireEmployee(String identity) {
		return mapper.map(hrApp.fireEmployee(TcKimlikNo.of(identity)),EmployeeResponse.class);
	}

	
	
}
