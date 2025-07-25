package com.hotel.service.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	String fieldString;

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldString) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldString));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldString = fieldString;
	}

}
