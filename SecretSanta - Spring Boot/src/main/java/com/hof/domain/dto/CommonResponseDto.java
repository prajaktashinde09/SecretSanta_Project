package com.hof.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseDto {
	
	private Integer responseCode;
	
	private String responseMessage;

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
	
}
