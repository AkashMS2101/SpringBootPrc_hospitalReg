package com.ty.springboot_hospitalapp.exception;

public class NoSuchMedItemsFound extends RuntimeException {

	private String message = "no such MedItems found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchMedItemsFound(String message) {
		super();
		this.message = message;
	}

	public NoSuchMedItemsFound() {
		super();
	}
}
