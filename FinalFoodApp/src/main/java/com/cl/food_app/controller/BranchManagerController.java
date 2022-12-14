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

import com.cl.food_app.dto.BranchManager;
import com.cl.food_app.service.BranchManagerService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class BranchManagerController {

	@Autowired
	private BranchManagerService service;

	@PostMapping("/savebranchManager/{branchId}")
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@RequestBody BranchManager branchManager,
			@PathVariable int branchId) {
		return service.saveBranchManager(branchManager, branchId);
	}

	@PutMapping("/updatebranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(
			@RequestBody BranchManager branchManager, @RequestParam int id) {
		return service.updateBranchManager(branchManager, id);
	}

	@DeleteMapping("/deletebranchManager/{branchManagerId}")
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(@PathVariable int branchManagerId) {
		return service.deleteBranchManager(branchManagerId);
	}

	@GetMapping("/getbranchManager/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(@PathVariable int id) {
		return service.getBranchManagerById(id);
	}

	@GetMapping("/getallbranchManager")
	public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager() {
		return service.findAllBranchManager();
	}
}
