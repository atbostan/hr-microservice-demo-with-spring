package com.bossware.hr.application.adapters;

import org.springframework.kafka.core.KafkaTemplate;
import com.bossware.hr.application.events.EventBase;
import com.bossware.hr.application.events.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EventPublisherKafkaAdapter implements EventPublisher<EventBase> {
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;

	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public void publishEvent(EventBase event) {
		try {
			var eventAsJson = objectMapper.writeValueAsString(event);
			kafkaTemplate.send("hr-events", eventAsJson);
			System.err.println("EventFired-> %s".formatted(eventAsJson));
		} catch (JsonProcessingException e) {
			System.err.println("Error has occured while converting event to json!");
		}
	}

}
