package com.ty.springboot_hospitalapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalapp.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{
	
}
