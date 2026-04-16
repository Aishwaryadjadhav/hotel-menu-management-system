package com.hotel.menu_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.menu_management.model.MenuItem;

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
	
	List<MenuItem> menulist = new ArrayList<>();

	@PostMapping ("/menu/add")
	public String addMenuItem(@RequestBody MenuItem item) {
		menulist.add(item);
		return "item added succesfully";
		
	}
	
	@GetMapping ("/menu/all")
	public List<MenuItem> getAllItems(){
		return menulist;
	}
	
	
	@GetMapping("menu/{id}")
	public MenuItem GetItemById(@PathVariable int id) {
		
		for(MenuItem item : menulist) {
			if(item.getId()==id) {
				return item;
			}
		}
		return null;
		
	}
	
	@PutMapping("/menu/update/{id}")
	public String UpdateItem(@PathVariable int id, @RequestBody MenuItem updateditem) {
		for (MenuItem item : menulist) {
			if(item.getId()==id) {
				item.setName(updateditem.getName());
				item.setPrice(updateditem.getPrice());
				 return "Item updated successfully";
			}
		}
		return "Item not found";
		
	}
	
	@DeleteMapping("menu/delete/{id}")
	public String DeleteItem(@PathVariable int id) {
		
		MenuItem itemRemove=null;
		
		for(MenuItem item : menulist) {
			if(item.getId()==id) {
				itemRemove = item;
				break;
			}
		}
		
		if(itemRemove != null) {
			menulist.remove(itemRemove);
			return "item deleted succesfully";
		}
		return "item not found";
		
	}

}
