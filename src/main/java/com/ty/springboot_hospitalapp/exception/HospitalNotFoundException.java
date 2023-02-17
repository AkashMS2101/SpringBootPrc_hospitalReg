package com.ty.springboot_hospitalapp.exception;

public class HospitalNotFoundException extends RuntimeException{
	private String message = "hospital not found for given id";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public HospitalNotFoundException(String message) {
		super();
		this.message=message;
	}
	
	public HospitalNotFoundException() {
		super();
	}
	
}