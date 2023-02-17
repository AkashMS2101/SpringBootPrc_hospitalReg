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
public class MedItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bill_id;
	@NotNull
	@NotBlank(message = "tablet_name should not be null")
	private String tablet_name;
	@NotNull
	@NotBlank(message = "tablet_amount should not be null")
	private double tablet_amount;
	@NotNull
	@NotBlank(message = "tablet_quantity should not be null")
	private int tablet_quantity;
	@ManyToOne
	private MedOrder medOrder;
	
}
