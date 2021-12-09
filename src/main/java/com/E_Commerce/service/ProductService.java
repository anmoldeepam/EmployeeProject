package com.E_Commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce.DAO.ProductDAO;
import com.E_Commerce.Exception.UserNotFoundException;
import com.E_Commerce.Model.Product;
@Service
public class ProductService {
	@Autowired
	public ProductDAO productDAO;
	
	public 	Product addProduct(Product product) {
		return productDAO.save(product);
	}
	
	public List<Product> getAllEmployees() {
		return productDAO.findAll();
	}
	public Product findProductById(Integer id) {
		return productDAO.findById(id).orElseThrow(()-> new UserNotFoundException("user by id "+id+"not found"));
	}

	public Product updateProduct(Product product) {
		return productDAO.save(product);
	}
	public void deleteProduct(Integer id) {
		productDAO.deleteById(id);
	}
}
