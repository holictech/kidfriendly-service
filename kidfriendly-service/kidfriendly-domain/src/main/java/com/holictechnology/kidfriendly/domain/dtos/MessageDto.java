package com.holictechnology.kidfriendly.domain.dtos;

public class MessageDto {

	private String message;
	
	private Boolean statusSuccess;

	public Boolean getStatusSuccess() {
		return statusSuccess;
	}

	public void setStatusSuccess(Boolean statusSuccess) {
		this.statusSuccess = statusSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}