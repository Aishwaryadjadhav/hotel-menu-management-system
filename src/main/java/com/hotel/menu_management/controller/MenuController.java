package com.hotel.menu_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	@GetMapping("/menu")
	public String Getmenu() {
		return "Welcome to Hotel Menu API";
		
	}
	
	@GetMapping("/menu/items")
	public List<String> getMenuItems(){
		return List.of("pizza", "burger", "pasta");
		
	}

}
