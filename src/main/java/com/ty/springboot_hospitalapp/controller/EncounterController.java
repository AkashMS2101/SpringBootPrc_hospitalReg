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

import com.ty.springboot_hospitalapp.dto.Encounter;
import com.ty.springboot_hospitalapp.dto.Person;
import com.ty.springboot_hospitalapp.service.EncounterService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService encounterService;
	
	@ApiOperation(value = " To save Encounter" , notes="This api is used to save an encounter by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Encounter not found for the given id"),
		@ApiResponse(code = 201, message = "Encounter saved")
	})
	@PostMapping("/saveencounter/{bid}/{pid}")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,@PathVariable int bid,@PathVariable int pid) {
		return encounterService.save(encounter, bid, pid);
	}
	
	@ApiOperation(value = " To delete Encounter" , notes="This api is used to delete an encounter by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Encounter not found for the given id"),
		@ApiResponse(code = 204, message = "Encounter deleted")
	})
	@DeleteMapping("/deleteencounter/{eid}")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@PathVariable int eid){
		return encounterService.delete(eid);
	}
	
	@ApiOperation(value = " To update Encounter" , notes="This api is used to update an encounter by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Encounter not found for the given id"),
		@ApiResponse(code = 201, message = "Encounter updated")
	})
	@PutMapping("/updateencounter/{eid}/{bid}")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,@PathVariable int eid,@PathVariable int bid){
		return encounterService.update(encounter, eid, bid);
	}
	
	@ApiOperation(value = " To get Encounter" , notes="This api is used to get an encounter by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Encounter not found for the given id"),
		@ApiResponse(code = 200, message = "Encounter found")
	})
	@GetMapping("/getencounter/{eid}")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@PathVariable int eid){
		return encounterService.getEncounterById(eid);
	}
	
	@ApiOperation(value = " To get All Encounter", notes = "This api is used to get all encounter")
	@ApiResponses({ @ApiResponse(code = 404, message = "no encounter registered"),
			@ApiResponse(code = 201, message = "Encounters found") })
	@GetMapping("/getallencounter")
	public List<Encounter> getAllEncounter() {
		return encounterService.getAll();
	} 
}
