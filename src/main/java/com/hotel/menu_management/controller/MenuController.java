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
import com.hotel.menu_management.repository.MenuRepository;

@RestController
public class MenuController {
	
	@Autowired
	private MenuRepository repo;
	
	@GetMapping("/menu")
	public String Getmenu() {
		return "Welcome to Hotel Menu API";
	}

	@PostMapping ("/menu/add")
	public String addMenuItem(@RequestBody MenuItem item) {
		repo.save(item);
		return "item save succesfully";
	}
	
	@GetMapping ("/menu/all")
	public List<MenuItem> getAllItems(){
		return repo.findAll();
	}
	
	
	@GetMapping("menu/{id}")
	public MenuItem GetItemById(@PathVariable int id) {
		return repo.findById(id).orElse(null);	
	}
	
	@PutMapping("/menu/update/{id}")
	public String UpdateItem(@PathVariable int id, @RequestBody MenuItem updateditem) {
		
		MenuItem item = repo.findById(id).orElse(null);
		
			if(item != null) {
				item.setName(updateditem.getName());
				item.setPrice(updateditem.getPrice());
				repo.save(item);
				 return "Item updated successfully";
			}
		
		return "Item not found";
		
	}
	
	@DeleteMapping("menu/delete/{id}")
	public String DeleteItem(@PathVariable int id) {
		repo.deleteById(id);
		return "item deleted successfully";
	}

}
