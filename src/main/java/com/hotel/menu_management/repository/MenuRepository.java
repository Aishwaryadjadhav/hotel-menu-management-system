package com.hotel.menu_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.menu_management.model.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Integer> {

}
