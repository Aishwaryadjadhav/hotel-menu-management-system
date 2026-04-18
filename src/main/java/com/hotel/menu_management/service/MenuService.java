package com.hotel.menu_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.menu_management.model.MenuItem;
import com.hotel.menu_management.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository repo;
	
	// ADD
	public String AddMenuItem(MenuItem item) {
		repo.save(item);
		return "item add succesfully";		
	}
	
	// GET ALL
	public List<MenuItem> GetAllItems(){
		return repo.findAll();
	}
	
	// GET BY ID
	public MenuItem GetItemById(int id) {
		return repo.findById(id).orElse(null);
		
	}
	
	// UPDATE
	public String UpdateItem(int id, MenuItem UpdatedItem) {
		MenuItem item = repo.findById(id).orElse(null);
		if(item != null) {
			item.setName(UpdatedItem.getName());
			item.setPrice(UpdatedItem.getPrice());
			repo.save(item);
			return " item updated successfully";
		}
		return "item not found";
		
	}
	
	// DELETE
	public String DeleteItem(int id) {
		repo.deleteById(id);
		return "item delete successfully";
	}


}
