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

import com.cl.food_app.dto.Staff;
import com.cl.food_app.service.StaffService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class StaffController {

	@Autowired
	private StaffService service;

	@PostMapping("/savestaff/{branchManagerId}")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff,
			@PathVariable int branchManagerId) {
		return service.saveStaff(staff, branchManagerId);
	}

	@PutMapping("/updatestaff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff, @RequestParam int id) {
		return service.updateStaff(staff, id);
	}

	@DeleteMapping("/deletestaff/{staffId}")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@PathVariable int staffId) {
		return service.deleteStaff(staffId);
	}

	@GetMapping("/getstaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@PathVariable int id) {
		return service.getStaffById(id);
	}

	@GetMapping("/getallstaff")
	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff() {
		return service.findAllStaff();
	}
}
