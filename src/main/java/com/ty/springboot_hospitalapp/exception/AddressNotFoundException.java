package com.ty.springboot_hospitalapp.exception;

public class AddressNotFoundException extends RuntimeException {

	private String message = "Address not found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public AddressNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AddressNotFoundException() {
		super();
	}
}
