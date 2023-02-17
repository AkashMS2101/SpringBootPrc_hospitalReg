package com.ty.springboot_hospitalapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalapp.dto.Encounter;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.repo.EncounterRepo;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo encounterRepo;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}

	public Encounter updateEncounter(Encounter encounter, int eid) {
		Encounter encounter2 = encounterRepo.findById(eid).get();
		if (encounter2 != null) {
			encounter.setEncounter_id(eid);
			return encounterRepo.save(encounter);
		} else {
			return null;
		}
	}
	
	public Encounter deleteEncounter(int eid) {
		if(encounterRepo.findById(eid).isPresent()) {
			Encounter encounter = encounterRepo.findById(eid).get();
			encounterRepo.delete(encounter);
			return encounter;
		}else {
			return null;
		}
	}
	
	public Encounter getEncounterByid(int id) {
		if(encounterRepo.findById(id).isPresent()) {
			return encounterRepo.findById(id).get();
		}else {
			return null;
		}
	}
	public List<Encounter> getAllEncounter() {
		return encounterRepo.findAll();
	}
}
