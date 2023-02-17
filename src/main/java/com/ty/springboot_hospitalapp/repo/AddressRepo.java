package com.ty.springboot_hospitalapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospitalapp.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	@Query("select a from Address a where a.ward_id=?1")
	public List<Address> getAddressByWard(int ward);
	
}
