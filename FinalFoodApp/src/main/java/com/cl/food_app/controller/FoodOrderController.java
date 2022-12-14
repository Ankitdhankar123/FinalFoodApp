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

import com.cl.food_app.dto.FoodOrder;
import com.cl.food_app.service.FoodOrderService;
import com.cl.food_app.util.ResponseStructure;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;

	@PostMapping("/savefoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder,
			@RequestParam("items") List<Integer> itemIds, @RequestParam("staffId") int staffId) {
		return service.saveFoodOrder(foodOrder, itemIds, staffId);
	}

	@PutMapping("/updatefoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,
			@RequestParam("items") List<Integer> itemIds, @RequestParam int id) {
		return service.updateFoodOrder(foodOrder, itemIds, id);
	}

	@DeleteMapping("/deletefoodOrder/{foodOrderId}")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@PathVariable int foodOrderId) {
		return service.deleteFoodOrder(foodOrderId);
	}

	@GetMapping("/getfoodOrder/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@PathVariable int id) {
		return service.getFoodOrderById(id);
	}

	@GetMapping("/getallfoodOrder")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder() {
		return service.findAllFoodOrder();
	}
}
