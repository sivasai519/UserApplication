package com.userinfo.utilites;


public class ErrorResponse {
	
	private int statusCode;
	
	private String response;

	public ErrorResponse(int statusCode, String response) {
		super();
		this.statusCode = statusCode;
		this.response = response;
	}

	public ErrorResponse() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	
}
