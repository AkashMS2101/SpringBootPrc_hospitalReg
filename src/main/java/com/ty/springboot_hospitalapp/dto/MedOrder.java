package com.ty.springboot_hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medOrder_id;
	@NotNull
	@NotBlank(message = "doctor_name should not be null")
	private String doctor_name;
	@NotNull
	@NotBlank(message = "date should not be null")
	private String date;
	@ManyToOne
	private Encounter encounter;

}
