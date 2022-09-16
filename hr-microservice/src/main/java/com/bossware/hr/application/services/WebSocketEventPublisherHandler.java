package com.bossware.hr.application.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.bossware.hr.application.events.EventBase;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WebSocketEventPublisherHandler implements WebSocketHandler {
	
	private final Map<String,WebSocketSession> sessions = new ConcurrentHashMap<>();
	private final ObjectMapper objectMapper;
	

	public WebSocketEventPublisherHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	
	@EventListener
	public void listenAndPublishEventToWebSocket(EventBase event) {
		sessions.forEach((sessionId,session)->{
			try {
				var eventAsJson = objectMapper.writeValueAsString(event);
				session.sendMessage(new TextMessage(eventAsJson));
			} catch (Exception e) {
				System.err.println("Error has occured while publish event to kafka");
			}
		});
	}
	
	
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			sessions.put(session.getId(), session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("WebSocketEventPublisherHandler.handleMessage()");
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.err.println("Error occured while web socket messaging : %s .".formatted(exception.getMessage()));
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		sessions.remove(session.getId());
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
