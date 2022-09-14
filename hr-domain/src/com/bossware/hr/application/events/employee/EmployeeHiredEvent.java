package com.bossware.hr.application.events.employee;

import com.bossware.hr.application.events.EventBase;
import com.bossware.hr.application.events.EventType;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

public class EmployeeHiredEvent extends EventBase {
	public EmployeeHiredEvent(TcKimlikNo identity) {
		super(identity, EventType.HIRE_EMPLOYEE);
	}
}
