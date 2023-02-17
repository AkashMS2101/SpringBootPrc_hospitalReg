package com.ty.springboot_hospitalapp.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler{

	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> IdnotFoundExcpHandler(HospitalNotFoundException idNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(idNotFoundException.getMessage());
		responseStructure.setData("hospital not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> AddressNotFoundException(AddressNotFoundException addressNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(addressNotFoundException.getMessage());
		responseStructure.setData("Address not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> BranchNotFoundException(BranchNotFoundException branchNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(branchNotFoundException.getMessage());
		responseStructure.setData("Branch not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EncounterNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> EncounterNotFoundException(EncounterNotFoundException encounterNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(encounterNotFoundException.getMessage());
		responseStructure.setData("encounter not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedItemsNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> MedItemsNotFoundException(MedItemsNotFoundException medItemsNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(medItemsNotFoundException.getMessage());
		responseStructure.setData("medItems not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedOrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> MedOrderNotFoundException(MedOrderNotFoundException medOrderNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(medOrderNotFoundException.getMessage());
		responseStructure.setData("medOrder not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> PersonNotFoundException(PersonNotFoundException personNotFoundException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(personNotFoundException.getMessage());
		responseStructure.setData("person not found for given id");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> error = ex.getAllErrors();
		Map<String, String > map = new LinkedHashMap<String, String>();
		for(ObjectError er : error) {
			String feildName =((FieldError)er).getField();
			String message = ((FieldError)er).getDefaultMessage();
			
			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public  ResponseEntity<Object> ConstraintViolationException(ConstraintViolationException constraintViolationException){
		Set<ConstraintViolation<?>> set = constraintViolationException.getConstraintViolations();
		List<String> list = new ArrayList<>();
		for(ConstraintViolation<?> constraintViolation : set) {
			String name = constraintViolation.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list , HttpStatus.BAD_REQUEST);
	}
	
}
