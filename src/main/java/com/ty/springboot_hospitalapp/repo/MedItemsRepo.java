package com.ty.springboot_hospitalapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalapp.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer>{

}
