package com.ty.springboot_hospitalapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalapp.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer>{
	
}
