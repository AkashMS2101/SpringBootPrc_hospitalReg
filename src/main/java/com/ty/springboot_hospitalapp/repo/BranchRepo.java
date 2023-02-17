package com.ty.springboot_hospitalapp.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

	@Query("select b from Branch b where b.hospital=?1")
	public List<Branch> getBranchByHospital(Hospital hospital);

}
