package com.ty.springboot_hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ward_id;
	@NotNull
	@NotBlank(message = "street should not be null")
	private String street;
	@NotNull
	@NotBlank(message = "city should not be null")
	private String city;
	private long pincode;

	public int getWard() {
		return ward_id;
	}

	public void setWard(int ward) {
		this.ward_id = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [ward=" + ward_id + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
