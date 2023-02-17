package com.ty.springboot_hospitalapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.springboot_hospitalapp.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

}
