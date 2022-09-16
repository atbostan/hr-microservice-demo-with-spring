package com.bossware.hrconsumerkafkamicroservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HrKafkaListenerService {
	
	@KafkaListener(topics = "hr-events",groupId = "hr-kafka-consumer")
	public void handleHrEvents(String hrEvent) {
		System.err.println("New event has arrived into Hr-Kafka-Consumer: %s".formatted(hrEvent));
	}

}
