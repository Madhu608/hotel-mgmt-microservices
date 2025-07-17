package com.rating.service.exceptions;

@SuppressWarnings("serial")
public class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);

	}

	public ApiException() {
		super();

	}
	
	public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
