package com.ty.springboot_hospitalapp.exception;

public class BranchNotFoundException extends RuntimeException {

	private String message = "Branch not found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public BranchNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BranchNotFoundException() {
		super();
	}
}
