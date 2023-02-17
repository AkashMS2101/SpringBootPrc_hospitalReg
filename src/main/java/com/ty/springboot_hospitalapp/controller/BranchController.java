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
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.service.BranchService;
import com.ty.springboot_hospitalapp.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@ApiOperation(value = " To save Branch" , notes="This api is used to save an branch by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Branch not found for the given id"),
		@ApiResponse(code = 201, message = "Branch saved")
	})
	@PostMapping("/savebranch/{hid}/{aid}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch,@PathVariable int hid,@PathVariable int aid) {
		return branchService.save(branch, hid,aid);
	}
	
	@ApiOperation(value = " To delete Branch" , notes="This api is used to delete an branch by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Branch not found for the given id"),
		@ApiResponse(code = 204, message = "Branch deleted")
	})
	@DeleteMapping("/deletebranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int id) {
		return branchService.delete(id);
	}
	
	@ApiOperation(value = " To update Branch" , notes="This api is used to update an branch by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Branch not found for the given id"),
		@ApiResponse(code = 201, message = "Branch updated")
	})
	@PutMapping("/updatebranch/{hid}/{aid}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@PathVariable int hid,@PathVariable int aid) {
		return branchService.update(hid, branch,aid);
	}
	
	@ApiOperation(value = " To get Branch" , notes="This api is used to get an branch by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Branch not found for the given id"),
		@ApiResponse(code = 200, message = "Branch found")
	})
	@GetMapping("/getbranch/{hid}")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@PathVariable int hid) {
		return branchService.getById(hid);
	}
	
	@ApiOperation(value = " To get All Branch" , notes="This api is used to get all branch ")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Branch not found for the given id"),
		@ApiResponse(code = 200, message = "Branch found")
	})
	@GetMapping("/getAllbranch")
	public List<Branch> getAll(){
		return branchService.getAll();
	}
	
	@ApiOperation(value = " To get Branch by hospital id" , notes="This api is used to get an branch by hospital id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Branch not found for the given hospital id"),
		@ApiResponse(code = 200, message = "Branch found")
	})
	@GetMapping("/getbranchesbyhid/{hid}")
	public ResponseEntity<ResponseStructure<List<Branch>>> getList(@PathVariable int hid){
		return branchService.getBranchByhid(hid);
	}
}
