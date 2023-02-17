package com.ty.springboot_hospitalapp.exception;

public class NoSuchAddressFoundException extends RuntimeException{
	
	private String message = "no such Address found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchAddressFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchAddressFoundException() {
		super();
	}
}
