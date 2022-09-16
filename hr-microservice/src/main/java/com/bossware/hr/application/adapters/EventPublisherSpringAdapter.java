package com.bossware.hr.application.adapters;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.bossware.hr.application.events.EventBase;
import com.bossware.hr.application.events.EventPublisher;
import com.bossware.hr.domain.annotations.Adapter;

@Service
@Adapter(port = EventPublisher.class)
public class EventPublisherSpringAdapter implements EventPublisher<EventBase> {
	private final ApplicationEventPublisher applicationEventPublisher;
	
	public EventPublisherSpringAdapter(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public void publishEvent(EventBase event) {
		applicationEventPublisher.publishEvent(event);
		System.err.println("EventFired-> %s".formatted(event.getIdentity().getValue()));

	}

}
