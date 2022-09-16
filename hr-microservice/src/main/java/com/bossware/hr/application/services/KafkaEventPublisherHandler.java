package com.bossware.hr.application.services;

import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bossware.hr.application.events.EventBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaEventPublisherHandler {
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	
	public KafkaEventPublisherHandler(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}
	
	@EventListener
	public void listenAndPublishEventToKafka(EventBase event) {
		try {
			var eventJson = objectMapper.writeValueAsString(event);
			kafkaTemplate.send("hr-events",eventJson);
			System.err.println("EventFiredfromhandler-> %s".formatted(event.getIdentity().getValue()));
			
		} catch (JsonProcessingException e) {
			System.err.println("Error On Publish Even To Kafka");
		}
	}
	

}

