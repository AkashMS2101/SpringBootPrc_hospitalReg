package com.ty.springboot_hospitalapp.exception;

public class PersonNotFoundException extends RuntimeException {

	private String message = "Person not found for given id";

	@Override
	public String getMessage() {
		return getMessage();
	}

	public PersonNotFoundException(String message) {
		super();
		this.message = message;
	}

	public PersonNotFoundException() {
		super();
	}

}
