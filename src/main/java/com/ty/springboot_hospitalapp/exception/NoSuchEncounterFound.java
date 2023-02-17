package com.ty.springboot_hospitalapp.exception;

public class NoSuchEncounterFound extends RuntimeException{

	private String message = "no such Encounter found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchEncounterFound(String message) {
		super();
		this.message = message;
	}

	public NoSuchEncounterFound() {
		super();
	}
}
