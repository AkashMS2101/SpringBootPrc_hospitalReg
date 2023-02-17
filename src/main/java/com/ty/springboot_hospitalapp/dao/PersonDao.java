package com.ty.springboot_hospitalapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.dto.Person;
import com.ty.springboot_hospitalapp.repo.PersonRepo;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepo personRepo;

	public Person savePerson(Person person) {
		return personRepo.save(person);
	}

	public Person deletePerson(int id) {
		Person person = personRepo.findById(id).get();
		if (person != null) {
			personRepo.delete(person);
			return person;
		} else {
			return null;
		}
	}

	public Person updatePeson(int id, Person person) {
		if (personRepo.findById(id).isPresent()) {
			person.setPid(id);
			return personRepo.save(person);
		} else {
			return null;
		}
	}

	public Person getPersonById(int id) {
		if (personRepo.findById(id).isPresent()) {
			return personRepo.findById(id).get();
		} else {
			return null;
		}
	}
	
	public List<Person> getAllPerson() {
		return personRepo.findAll();
	}
}
