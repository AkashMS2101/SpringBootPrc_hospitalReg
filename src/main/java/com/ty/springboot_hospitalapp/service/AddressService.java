package com.ty.springboot_hospitalapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.springboot_hospitalapp.dao.AddressDao;
import com.ty.springboot_hospitalapp.dto.Address;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.exception.AddressNotFoundException;
import com.ty.springboot_hospitalapp.exception.NoSuchAddressFoundException;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> save(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		Address address2 = addressDao.saveAddress(address);
		structure.setData(address2);
		structure.setMessage("saved");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> update(int id, Address address) {
		Address address2 = addressDao.updateAddress(id, address);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (address2 != null) {
			structure.setData(address2);
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new AddressNotFoundException("Address not found for given id "+id+" to update");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> delete(int id) {
		Address address = addressDao.deleteAddress(id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (address != null) {
			structure.setData(address);
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new AddressNotFoundException("Address not found for given id "+id+"to delete");
			
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getbyid(int id) {
		Address address = addressDao.getAddressById(id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (address != null) {
			structure.setData(address);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchAddressFoundException("Address not found for given id "+id);
		}
	}

	public List<Address> getAll(){
		return addressDao.getAllAddress();
	}
}
