package com.userinfo.utilites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private String statusCode;

	private String statusResponse;

	public UserResponse(String statusCode, String statusResponse) {
		super();
		this.statusCode = statusCode;
		this.statusResponse = statusResponse;
	}

	public UserResponse() {
		super();
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusResponse() {
		return statusResponse;
	}

	public void setStatusResponse(String statusResponse) {
		this.statusResponse = statusResponse;
	}

}
