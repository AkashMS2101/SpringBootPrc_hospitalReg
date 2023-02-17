package com.ty.springboot_hospitalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.springboot_hospitalapp.dto.Person;
import com.ty.springboot_hospitalapp.service.PersonService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@ApiOperation(value = " To save Person", notes = "This api is used to save an Person by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "Person not found for the given id"),
			@ApiResponse(code = 201, message = "Person saved") })
	@PostMapping("/personsave")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personService.save(person);
	}

	@ApiOperation(value = " To delete Person", notes = "This api is used to delete an Person by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "Person not found for the given id"),
			@ApiResponse(code = 204, message = "Person deleted") })
	@DeleteMapping("/persondelete/{id}")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@PathVariable int id) {
		return personService.delete(id);
	}

	@ApiOperation(value = " To update Person", notes = "This api is used to update an Person by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "Person not found for the given id"),
			@ApiResponse(code = 201, message = "Person updated") })
	@PutMapping("/personupdate/{id}")
	public ResponseEntity<ResponseStructure<Person>> updatePerson( @RequestBody Person person,@PathVariable int id) {
		return personService.update(id, person);
	}

	@ApiOperation(value = " To get Person", notes = "This api is used to get an Person by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "Person not found for the given id"),
			@ApiResponse(code = 200, message = "Person found") })
	@GetMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPerson(@PathVariable int id) {
		return personService.getById(id);
	}
	
	@ApiOperation(value = " To get All Person", notes = "This api is used to get all Person")
	@ApiResponses({ @ApiResponse(code = 404, message = "no persons registered"),
			@ApiResponse(code = 201, message = "Person found") })
	@GetMapping("/getallperson")
	public List<Person> getAllPerson() {
		return personService.getAll();
	} 
}
