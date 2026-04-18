package com.hotel.menu_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.menu_management.model.MenuItem;
import com.hotel.menu_management.service.MenuService;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@GetMapping("/menu")
	public String Getmenu() {
		return "Welcome to Hotel Menu API";
	}

	@PostMapping ("/menu/add")
	public String addMenuItem(@RequestBody MenuItem item) {
		return service.AddMenuItem(item);
		
	}
	
	@GetMapping ("/menu/all")
	public List<MenuItem> getAllItems(){
		return service.GetAllItems();
	}
	
	
	@GetMapping("menu/{id}")
	public MenuItem GetItemById(@PathVariable int id) {
		return service.GetItemById(id);	
	}
	
	@PutMapping("/menu/update/{id}")
	public String UpdateItem(@PathVariable int id, @RequestBody MenuItem updateditem) {
		return service.UpdateItem(id, updateditem);
		
	}
	
	@DeleteMapping("menu/delete/{id}")
	public String DeleteItem(@PathVariable int id) {
		return service.DeleteItem(id);
		
	}

}
