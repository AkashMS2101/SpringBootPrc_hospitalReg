package com.ty.springboot_hospitalapp.exception;

public class NoSuchHospitalFound extends RuntimeException{
	
	private String message = "no such Hospital  found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchHospitalFound(String message) {
		super();
		this.message = message;
	}

	public NoSuchHospitalFound() {
		super();
	}
}
