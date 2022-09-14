package com.bossware.hr.application;

import java.util.Optional;

import com.bossware.hr.domain.Employee;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

public interface HrApplication {
	Employee hireEmployee(Employee employee);
	Employee fireEmployee(TcKimlikNo identity);
	Optional<Employee> getEmployee(TcKimlikNo identity);
}
