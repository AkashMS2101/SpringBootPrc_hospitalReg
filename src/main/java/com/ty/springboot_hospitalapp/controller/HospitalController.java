package com.ty.springboot_hospitalapp.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalapp.dto.Encounter;
import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.service.HospitalService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = " To Save Hospital" , notes="This api is used to save an hospital")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Hospital not found for the given id"),
		@ApiResponse(code = 201, message = "Hospital saved")
	})
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.save(hospital);
	}

	
	@ApiOperation(value = " To Update Hospital" , notes="This api is used to update an hospital")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Hospital not found for the given id"),
		@ApiResponse(code = 201, message = "Hospital updated")
	})
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital( @RequestParam int id,@RequestBody Hospital hospital) {
		return service.update(id, hospital);
	}

	@ApiOperation(value = " To delete Hospital" , notes="This api is used to delete an hospital by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Hospital not found for the given id"),
		@ApiResponse(code = 204, message = "Hospital deleted")
	})
	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) {
		return service.delete(id);
	}
	
	@ApiOperation(value = " To get Hospital" , notes="This api is used to get an hospital by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Hospital not found for the given id"),
		@ApiResponse(code = 200, message = "Hospital found")
	})
	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByid(@RequestParam int id) {
		return service.getById(id);
	}
	
	@ApiOperation(value = " To get All Hospital", notes = "This api is used to get all hospital")
	@ApiResponses({ @ApiResponse(code = 404, message = "no hospital registered"),
			@ApiResponse(code = 201, message = "Hospitals found") })
	@GetMapping("/getallhospital")
	public List<Hospital> getAllHospitals() {
		return service.getAll();
	} 
}
