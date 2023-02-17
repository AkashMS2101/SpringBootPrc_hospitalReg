package com.ty.springboot_hospitalapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalapp.dao.AddressDao;
import com.ty.springboot_hospitalapp.dao.BranchDao;
import com.ty.springboot_hospitalapp.dao.HospitalDao;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.exception.AddressNotFoundException;
import com.ty.springboot_hospitalapp.exception.BranchNotFoundException;
import com.ty.springboot_hospitalapp.exception.HospitalNotFoundException;
import com.ty.springboot_hospitalapp.exception.NoSuchBranchFound;
import com.ty.springboot_hospitalapp.exception.NoSuchHospitalFound;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	HospitalDao hospitalDao;
	
	@Autowired
	AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Branch>> save(Branch branch, int id,int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if ((hospitalDao.getHospitalById(id) != null) && (addressDao.getAddressById(aid) !=null)) {
			branch.setHospital(hospitalDao.getHospitalById(id));
			branch.setAddress(addressDao.getAddressById(aid));
			branchDao.saveBranch(branch);

			structure.setData(branch);
			structure.setMessage("successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
		} else {
			throw new HospitalNotFoundException("hospital not found for given id "+id+"to save branch");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> delete(int id) {
		Branch branch = branchDao.deleteBranch(id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (branch != null) {
			structure.setData(branch);
			structure.setMessage("successfully deleted");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException("Branch not found for given id "+id+" to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getById(int id) {
		Branch branch = branchDao.getBranchById(id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (branch != null) {
			structure.setData(branch);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchBranchFound("Branch not found for given id "+id);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> update(int id, Branch branch,int aid) {
		Branch branch2 = branchDao.updateBranch(id, branch,aid);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (branch2 != null) {
			structure.setData(branch);
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException("Branch not found for given id "+id+" to update");
		}
	}

	public List<Branch> getAll(){
		return branchDao.getAllBranch();
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByhid(int id){
		Hospital hospital = hospitalDao.getHospitalById(id);
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		if(hospital!=null) {
			structure.setData(branchDao.GetBranchByHospital(hospital));
			structure.setMessage("found");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
		}else {
			throw new NoSuchHospitalFound("hospital not found for given id "+id+" to get branches");
		}
	}
}
