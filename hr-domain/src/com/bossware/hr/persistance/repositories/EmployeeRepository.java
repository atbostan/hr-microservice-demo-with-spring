package com.bossware.hr.persistance.repositories;

import java.util.Optional;

import com.bossware.hr.domain.Employee;
import com.bossware.hr.domain.annotations.Port;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

@Port
public interface EmployeeRepository {
	boolean exists(TcKimlikNo identity);

	Employee persist(Employee employee);

	Optional<Employee> findByIdentity(TcKimlikNo identity);

	void remove(Employee employee);
}
