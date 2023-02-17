package com.ty.springboot_hospitalapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.repo.AddressRepo;
import com.ty.springboot_hospitalapp.repo.BranchRepo;
import com.ty.springboot_hospitalapp.repo.HospitalRepo;

@Repository
public class HospitalDao {

	@Autowired
	private BranchRepo branchRepo;
	
	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired private AddressRepo addressRepo;
	@Autowired
	private HospitalRepo repo;

	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		if (repo.findById(id).isPresent()) {
			hospital.setId(id);
			return repo.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital deleteHospital(int id) {
		if (repo.findById(id).isPresent()) {
			Hospital hospital = repo.findById(id).get();
			repo.delete(hospital);
			return hospital;
		} else {
			return null;
		}
	}

	public Hospital getHospitalById(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Hospital> getAllHospital() {
		return repo.findAll();
	}

}
