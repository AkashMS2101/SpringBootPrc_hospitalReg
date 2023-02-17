package com.ty.springboot_hospitalapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.springboot_hospitalapp.dao.HospitalDao;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.exception.HospitalNotFoundException;
import com.ty.springboot_hospitalapp.exception.NoSuchHospitalFound;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> save(Hospital hospital) {
		Hospital hospital2 = dao.saveHospital(hospital);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		structure.setData(hospital);
		structure.setMessage("saved");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> update(int id, Hospital hospital) {
		Hospital daoHospital = dao.updateHospital(id, hospital);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (daoHospital != null) {
			structure.setData(hospital);
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new HospitalNotFoundException("Hospital is not found for given id "+id+" to update");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> delete(int id) {
		Hospital hospital = dao.deleteHospital(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			structure.setData(hospital);
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new HospitalNotFoundException("Hospital is not found for given id "+id+" to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getById(int id) {
		Hospital hospital = dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			structure.setData(hospital);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchHospitalFound("Hospital is not found for given id "+id);
		}
	}
	
	public List<Hospital> getAll(){
		return dao.getAllHospital();
	}

}
