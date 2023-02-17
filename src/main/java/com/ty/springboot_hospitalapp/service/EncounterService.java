package com.ty.springboot_hospitalapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalapp.dao.BranchDao;
import com.ty.springboot_hospitalapp.dao.EncounterDao;
import com.ty.springboot_hospitalapp.dao.PersonDao;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.Encounter;
import com.ty.springboot_hospitalapp.dto.Person;
import com.ty.springboot_hospitalapp.exception.BranchNotFoundException;
import com.ty.springboot_hospitalapp.exception.EncounterNotFoundException;
import com.ty.springboot_hospitalapp.exception.NoSuchEncounterFound;
import com.ty.springboot_hospitalapp.exception.PersonNotFoundException;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Encounter>> save(Encounter encounter, int bid, int pid) {
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		Branch branch = branchDao.getBranchById(bid);
		Person person = personDao.getPersonById(pid);

		List<Branch> list = new ArrayList<>();
		list.add(branch);

		encounter.setPerson(person);
		encounter.setList(list);

		if (encounter != null) {
			encounterDao.saveEncounter(encounter);
			structure.setData(encounter);
			structure.setMessage("saved");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);
		} else if(branch==null){
			throw new BranchNotFoundException("Branch not found for given id "+bid +"to add encounter");
		}else {
			throw new PersonNotFoundException("Person not found for given id "+pid +"to add encounter");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> update(Encounter encounter, int eid, int bid) {
		Encounter oldEncounter = encounterDao.getEncounterByid(eid);

		Person person = oldEncounter.getPerson();

		Branch branch = branchDao.getBranchById(bid);

		List<Branch> list = oldEncounter.getList();
		list.add(branch);

		encounter.setList(list);
		encounter.setPerson(person);

		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		if (encounter != null) {
			encounterDao.updateEncounter(encounter, eid);
			structure.setData(encounter);
			structure.setMessage("saved");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new EncounterNotFoundException("Encounter is not found for given id "+eid+" to update");
		}
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> delete(int id){
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		Encounter encounter = encounterDao.getEncounterByid(id);
		if(encounter!=null) {
			encounterDao.deleteEncounter(id);
			structure.setData(encounter);
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		}else {
			throw new EncounterNotFoundException("Encounter is not found for given id "+id+" to delete");
		}
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id){
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		Encounter encounter = encounterDao.getEncounterByid(id);
		if(encounter!=null) {
			structure.setData(encounter);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		}else {
			throw new NoSuchEncounterFound("Encounter is not found for given id "+id);
		}
	}
	
	public List<Encounter> getAll(){
		return encounterDao.getAllEncounter();
	}
}
