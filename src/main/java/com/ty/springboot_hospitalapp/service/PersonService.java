package com.ty.springboot_hospitalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.springboot_hospitalapp.dao.PersonDao;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.Person;
import com.ty.springboot_hospitalapp.exception.PersonNotFoundException;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> save(Person person) {
		Person person2 = dao.savePerson(person);
		ResponseStructure<Person> structure = new ResponseStructure<>();
		structure.setData(person2);
		structure.setMessage("saved");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> update(int id, Person person) {
		Person person2 = dao.updatePeson(id, person);
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (person2 != null) {
			structure.setData(person);
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException("Person not found for the given id "+id+" to update");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> delete(int id) {
		Person person = dao.deletePerson(id);
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (person != null) {
			structure.setData(person);
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException("Person not found for the given id "+id+" to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> getById(int id) {
		Person person = dao.getPersonById(id);
		ResponseStructure<Person> structure = new ResponseStructure<>();
		if (person != null) {
			structure.setData(person);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException("Person not found for the given id "+id);
		}
	}
	
	public List<Person> getAll(){
		return dao.getAllPerson();
	}
}
