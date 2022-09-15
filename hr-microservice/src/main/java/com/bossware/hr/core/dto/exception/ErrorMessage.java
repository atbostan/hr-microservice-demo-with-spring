package com.bossware.hr.core.dto.exception;

public class ErrorMessage {
	private final String message;
	private final String status;
	private final int statusCode;
	private final String payload;

	public ErrorMessage(String message, String status, int statusCode, String payload) {
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public int getStatusCode() {
		return statusCode;
	}
	
	public String getPayload() {
		return payload;
	}

}
