package com.bossware.hr.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bossware.hr.application.HrApplication;
import com.bossware.hr.application.events.EventBase;
import com.bossware.hr.application.events.EventPublisher;
import com.bossware.hr.application.impl.StandardHrApplication;
import com.bossware.hr.persistance.repositories.EmployeeRepository;

@Configuration
public class HrApplicationConfig {
	

	@Bean
	public HrApplication createHrApp(EmployeeRepository employeeRepository, EventPublisher<EventBase> publisher) {
		return new StandardHrApplication(employeeRepository, publisher);
	}

}
