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

import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.dto.MedItems;
import com.ty.springboot_hospitalapp.service.MedItemsService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {

	@Autowired
	private MedItemsService medItemsService;

	@ApiOperation(value = " To save MedItems", notes = "This api is used to save an medItems by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedItems not found for the given id"),
			@ApiResponse(code = 201, message = "MedItems saved") })
	@PostMapping("/savemeditems/{mid}")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItem(@Valid @RequestBody MedItems medItems,
			@PathVariable int mid) {
		return medItemsService.save(medItems, mid);
	}

	@ApiOperation(value = " To update MedItems", notes = "This api is used to update an MedItems by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedItems not found for the given id"),
			@ApiResponse(code = 201, message = "MedItems updated") })
	@PutMapping("/updatemeditems/{mid}")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestBody MedItems medItems,
			@PathVariable int mid) {
		return medItemsService.update(medItems, mid);
	}

	@ApiOperation(value = " To get MedItems", notes = "This api is used to get an MedItems by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedItems not found for the given id"),
			@ApiResponse(code = 200, message = "MedItems found") })
	@GetMapping("/getmeditems/{mid}")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItems(@PathVariable int mid) {
		return medItemsService.get(mid);
	}

	@ApiOperation(value = " To delete MedItems", notes = "This api is used to delete an MedItems by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedItems not found for the given id"),
			@ApiResponse(code = 204, message = "MedItems deleted") })
	@DeleteMapping("/deletemeditems/{mid}")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@PathVariable int mid) {
		return medItemsService.delete(mid);
	}
	
	@ApiOperation(value = " To get All MedItems", notes = "This api is used to get all MedItems")
	@ApiResponses({ @ApiResponse(code = 404, message = "no MedItems registered"),
			@ApiResponse(code = 201, message = "MedItems found") })
	@GetMapping("/getallmeditems")
	public List<MedItems> getAllMedItems() {
		return medItemsService.getAll();
	} 
}
