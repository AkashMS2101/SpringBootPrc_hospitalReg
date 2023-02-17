package com.ty.springboot_hospitalapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springboot_hospitalapp.dto.Address;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.repo.AddressRepo;
import com.ty.springboot_hospitalapp.repo.BranchRepo;
import com.ty.springboot_hospitalapp.repo.HospitalRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo branchRepo;

	@Autowired
	private HospitalRepo hospitalRepo;

	@Autowired
	private AddressRepo addressRepo;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch updateBranch(int id, Branch branch, int aid) {
		Hospital hospital = hospitalRepo.findById(id).get();
		Address address = addressRepo.findById(aid).get();
		Branch branch2 = branchRepo.findById(id).get();
		if (branch2 != null) {
			branch.setBranch_id(id);
			branch.setHospital(hospital);
			branch.setAddress(address);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch deleteBranch(int id) {
		if (branchRepo.findById(id).isPresent()) {
			Branch branch = branchRepo.findById(id).get();
			branchRepo.delete(branchRepo.findById(id).get());
			return branch;
		} else {
			return null;
		}
	}

	public Branch getBranchById(int id) {
		if (branchRepo.findById(id).isPresent()) {
			return branchRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Branch> getAllBranch() {
		return branchRepo.findAll();
	}

	public List<Branch> GetBranchByHospital(Hospital hospital) {
		return branchRepo.getBranchByHospital(hospital);
	}

}
