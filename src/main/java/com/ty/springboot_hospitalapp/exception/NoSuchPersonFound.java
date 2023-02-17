package com.ty.springboot_hospitalapp.exception;

public class NoSuchPersonFound extends RuntimeException{
	
	private String message = "no such person found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchPersonFound(String message) {
		super();
		this.message = message;
	}

	public NoSuchPersonFound() {
		super();
	}
}
