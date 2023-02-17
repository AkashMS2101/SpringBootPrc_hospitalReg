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

import com.ty.springboot_hospitalapp.dto.MedItems;
import com.ty.springboot_hospitalapp.dto.MedOrder;
import com.ty.springboot_hospitalapp.service.MedOrderService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService medOrderService;

	@ApiOperation(value = " To save MedIOrder", notes = "This api is used to save an MedIOrder by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedIOrder not found for the given id"),
			@ApiResponse(code = 201, message = "MedIOrder saved") })
	@PostMapping("/savemedorder/{eid}")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@Valid @RequestBody MedOrder medOrder,
			@PathVariable int eid) {
		return medOrderService.save(medOrder, eid);
	}

	@ApiOperation(value = " To update MedIOrder", notes = "This api is used to update an MedIOrder by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedIOrder not found for the given id"),
			@ApiResponse(code = 201, message = "MedIOrder updated") })
	@PutMapping("/updatemedorder/{mid}")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,
			@PathVariable int mid) {
		return medOrderService.update(medOrder, mid);
	}

	@ApiOperation(value = " To get MedIOrder", notes = "This api is used to get an MedIOrder by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedIOrder not found for the given id"),
			@ApiResponse(code = 200, message = "MedIOrder found") })
	@GetMapping("/getmedorder/{mid}")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(@PathVariable int mid) {
		return medOrderService.get(mid);
	}

	@ApiOperation(value = " To delete MedIOrder", notes = "This api is used to delete an MedIOrder by id")
	@ApiResponses({ @ApiResponse(code = 404, message = "MedIOrder not found for the given id"),
			@ApiResponse(code = 204, message = "MedIOrder deleted") })
	@DeleteMapping("/deletemedorder/{mid}")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@PathVariable int mid) {
		return medOrderService.delete(mid);
	}
	
	@ApiOperation(value = " To get All MedOrder", notes = "This api is used to get all MedOrder")
	@ApiResponses({ @ApiResponse(code = 404, message = "no MedOrder registered"),
			@ApiResponse(code = 201, message = "MedOrder found") })
	@GetMapping("/getallmedorder")
	public List<MedOrder> getAllMedItems() {
		return medOrderService.getAll();
	} 
}
