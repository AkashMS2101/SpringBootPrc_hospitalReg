package com.ty.springboot_hospitalapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springboot_hospitalapp.dto.Address;
import com.ty.springboot_hospitalapp.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address updateAddress(int id, Address address) {
		Address address2 = addressRepo.findById(id).get();
		if (address2 != null) {
			address.setWard(id);
			return addressRepo.save(address);
		} else {
			return null;
		}
	}

	public Address deleteAddress(int id) {
		if (addressRepo.findById(id).isPresent()) {
			Address address = addressRepo.findById(id).get();
			addressRepo.delete(address);
			return address;
		} else {
			return null;
		}
	}

	public Address getAddressById(int id) {
		if (addressRepo.findById(id).isPresent()) {
			return addressRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Address> getAllAddress() {
		return addressRepo.findAll();
	}

}
