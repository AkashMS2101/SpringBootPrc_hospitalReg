package com.ty.springboot_hospitalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.springboot_hospitalapp.dto.Address;
import com.ty.springboot_hospitalapp.service.AddressService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@ApiOperation(value = " To save Address" , notes="This api is used to save an address by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Address not found for the given id"),
		@ApiResponse(code = 201, message = "Address saved")
	})
	@PostMapping("/saveadd")
	public ResponseEntity<ResponseStructure<Address>> save(@Valid @RequestBody Address address) {
		return addressService.save(address);
	}

	@ApiOperation(value = " To update Address" , notes="This api is used to update an address by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Address not found for the given id"),
		@ApiResponse(code = 201, message = "Address updated")
	})
	@PutMapping("/updateadd/{id}")
	public ResponseEntity<ResponseStructure<Address>> update(@RequestBody Address address, @PathVariable int id) {
		return addressService.update(id, address);
	}
	
	@ApiOperation(value = " To delete Address" , notes="This api is used to delete an address by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Address not found for the given id"),
		@ApiResponse(code = 204, message = "Address deleted")
	})
	@DeleteMapping("/deleteadd/{id}")
	public ResponseEntity<ResponseStructure<Address>> delete(@PathVariable int id) {
		return addressService.delete(id);
	}

	@ApiOperation(value = " To get Address" , notes="This api is used to get an address by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Address not found for the given id"),
		@ApiResponse(code = 200, message = "Address found")
	})
	@GetMapping("/getadd/{id}")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@PathVariable int id) {
		return addressService.getbyid(id);
	}

	@GetMapping("/getalladdress")
	public List<Address> getallAddress(){
		return addressService.getAll();
	}
}
