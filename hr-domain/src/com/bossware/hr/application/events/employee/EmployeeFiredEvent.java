package com.bossware.hr.application.events.employee;

import com.bossware.hr.application.events.EventBase;
import com.bossware.hr.application.events.EventType;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

public class EmployeeFiredEvent extends EventBase {

	public EmployeeFiredEvent(TcKimlikNo identity) {
		super(identity, EventType.FIRE_EMPLOYEE);
	}

}
