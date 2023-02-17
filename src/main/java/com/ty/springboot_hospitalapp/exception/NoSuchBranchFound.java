package com.ty.springboot_hospitalapp.exception;

public class NoSuchBranchFound extends RuntimeException{

	private String message = "No such Branch found for given id";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchBranchFound(String message) {
		super();
		this.message = message;
	}

	public NoSuchBranchFound() {
		super();
	}
}
