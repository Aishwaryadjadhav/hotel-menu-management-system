package com.hotel.menu_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.menu_management.exception.ResourceNotFoundException;
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
		   MenuItem item = repo.findById(id).orElse(null);

		    if (item == null) {
		        throw new ResourceNotFoundException("Item not found with id " + id);
		    }

		    return item;
		
	}
	
	// UPDATE
	public String UpdateItem(int id, MenuItem UpdatedItem) {
		MenuItem item = repo.findById(id).orElse(null);
		  if (item == null) {
		        throw new ResourceNotFoundException("Item not found with id " + id);
		    }

		    item.setName(UpdatedItem.getName());
		    item.setPrice(UpdatedItem.getPrice());
		    repo.save(item);

		    return "Item updated successfully";
		
	}
	
	// DELETE
	public String DeleteItem(int id) {
		   MenuItem item = repo.findById(id).orElse(null);

		    if (item == null) {
		        throw new ResourceNotFoundException("Item not found with id " + id);
		    }

		    repo.delete(item);
		    return "Item deleted successfully";
	}


}
