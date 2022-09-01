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

import com.cl.food_app.dto.Menu;
import com.cl.food_app.service.MenuService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class MenuController {

	@Autowired
	private MenuService service;

	@PostMapping("/savemenu/{branchManagerId}")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu, @PathVariable int branchManagerId) {
		return service.saveMenu(menu, branchManagerId);
	}

	// There is no need for updating the menu table
	@PutMapping("/updatemenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu, @RequestParam int id) {
		return service.updateMenu(menu, id);
	}

	@DeleteMapping("/deletemenu/{menuId}")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@PathVariable int menuId) {
		return service.deleteMenu(menuId);
	}

	@GetMapping("/getmenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@PathVariable int id) {
		return service.getMenuById(id);
	}

	@GetMapping("/getallmenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu() {
		return service.findAllMenu();
	}
}
