package com.bossware.hr.application.events;

import java.util.UUID;

import com.bossware.hr.domain.valueObjects.TcKimlikNo;

public abstract class EventBase {
	private final EventType eventType;
	private final String eventId = UUID.randomUUID().toString();
	private final TcKimlikNo identity;

	public EventBase(TcKimlikNo identity, EventType eventType) {
		this.identity = identity;
		this.eventType = eventType;
	}

	public EventType getEventType() {
		return eventType;
	}

	public String getEventId() {
		return eventId;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}
}
