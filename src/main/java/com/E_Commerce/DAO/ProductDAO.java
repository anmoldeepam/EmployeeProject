package com.E_Commerce.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.E_Commerce.Model.Product;

public interface ProductDAO extends JpaRepository<Product,Integer>{
	
	
	


}
