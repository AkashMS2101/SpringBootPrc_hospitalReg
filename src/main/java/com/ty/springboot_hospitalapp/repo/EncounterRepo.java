package com.ty.springboot_hospitalapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospitalapp.dto.Address;
import com.ty.springboot_hospitalapp.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {

	
}
