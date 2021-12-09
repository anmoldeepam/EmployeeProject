package com.E_Commerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.E_Commerce.Model.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
