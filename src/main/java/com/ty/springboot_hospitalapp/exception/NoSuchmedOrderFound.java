package com.ty.springboot_hospitalapp.exception;

public class NoSuchmedOrderFound extends RuntimeException{
	
	private String message = "no such MedOrder found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchmedOrderFound(String message) {
		super();
		this.message = message;
	}

	public NoSuchmedOrderFound() {
		super();
	}
}
