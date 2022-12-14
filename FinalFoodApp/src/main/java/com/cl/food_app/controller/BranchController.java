package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Branch;
import com.cl.food_app.service.BranchService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	private BranchService service;

	@PostMapping("/branch/{adminId}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @PathVariable int adminId) {
		return service.saveBranch(branch, adminId);
	}

	@PutMapping("/branchupdate")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @RequestParam int id) {
		return service.updateBranch(branch, id);
	}

	@DeleteMapping("/deletebranch/{branchId}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int branchId) {
		return service.deleteBranch(branchId);
	}

	@GetMapping("/getbranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int id) {
		return service.getBranchById(id);
	}

	@GetMapping("/getallbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch() {
		return service.findAllBranch();
	}
}
