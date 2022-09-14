package com.bossware.hr.application.impl;

import java.util.Optional;

import com.bossware.hr.application.HrApplication;
import com.bossware.hr.application.events.EventBase;
import com.bossware.hr.application.events.EventPublisher;
import com.bossware.hr.application.events.employee.EmployeeFiredEvent;
import com.bossware.hr.application.events.employee.EmployeeHiredEvent;
import com.bossware.hr.application.exceptions.employee.EmployeeNotFoundException;
import com.bossware.hr.application.exceptions.employee.ExistingEmployeeException;
import com.bossware.hr.domain.Employee;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;
import com.bossware.hr.persistance.repositories.EmployeeRepository;

public class StandardHrApplication implements HrApplication{

	private final EmployeeRepository employeeRepository;
	private final EventPublisher<EventBase> publisher;
	
	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher<EventBase> publisher) {
		this.employeeRepository = employeeRepository;
		this.publisher = publisher;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		var identity = employee.getIdentity();
		if (employeeRepository.exists(identity)) {
			throw new ExistingEmployeeException("Employee with identity (%s) already exists.".formatted(identity.getValue()));
		}
		Employee persistedEmployee = employeeRepository.persist(employee);
		publisher.publishEvent(new EmployeeHiredEvent(identity));
		return persistedEmployee;
	}

	@Override
	public Employee fireEmployee(TcKimlikNo identity) {
		var employeeFound = employeeRepository.findByIdentity(identity);
		var employee = employeeFound.orElseThrow(() -> new EmployeeNotFoundException("Employee with identity (%s) does not exist.".formatted(identity.getValue())));
		employeeRepository.remove(employee);
		publisher.publishEvent(new EmployeeFiredEvent(identity));		
		return employee;
	}

	@Override
	public Optional<Employee> getEmployee(TcKimlikNo identity) {
		return employeeRepository.findByIdentity(identity);
	}

}
