package com.userinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.userinfo.utilites.ErrorResponse;

@ControllerAdvice
public class CustomerExceptionHandler {

	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleCustomerNotFoundException(UserNotFoundException userNotFoundException) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), userNotFoundException.getMessage());
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
	public @ResponseBody ErrorResponse handleCustomerAlreadyExistsException(UserAlreadyExistException userAlreadyExistException) {
		return new ErrorResponse(HttpStatus.ALREADY_REPORTED.value(), userAlreadyExistException.getMessage());
	}
}
