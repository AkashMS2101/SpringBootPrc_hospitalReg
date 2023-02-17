package com.ty.springboot_hospitalapp.exception;

public class MedOrderNotFoundException extends RuntimeException {

private String message = "MedOrder not found for given id";
	
	@Override
	public String getMessage() {
		return getMessage();
	}
	
	public MedOrderNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedOrderNotFoundException() {
		super();
	}

}
