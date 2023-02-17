package com.ty.springboot_hospitalapp.exception;

public class EncounterNotFoundException extends RuntimeException{

	private String message = "Encounter not found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public EncounterNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EncounterNotFoundException() {
		super();
	}
}
