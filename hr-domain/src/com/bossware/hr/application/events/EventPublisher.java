package com.bossware.hr.application.events;

import com.bossware.hr.domain.annotations.Port;

@Port
public interface EventPublisher<Event> {
	public void publishEvent(Event event);
}