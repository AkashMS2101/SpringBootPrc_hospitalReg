package com.ty.springboot_hospitalapp.exception;

public class MedItemsNotFoundException extends RuntimeException {

	private String message = "MedItems not found for given id";
	
	@Override
	public String getMessage() {
		return getMessage();
	}
	
	public MedItemsNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedItemsNotFoundException() {
		super();
	}

}
