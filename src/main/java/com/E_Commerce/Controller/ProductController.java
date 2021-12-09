package com.E_Commerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.E_Commerce.Model.Offers;
import com.E_Commerce.Model.Product;
import com.E_Commerce.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id){
		Product product = productService.findProductById(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllEmployees(){
		List<Product> product = productService.getAllEmployees();
		return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product newProduct = productService.addProduct(product);
		return new ResponseEntity<Product>(newProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updatePrduct(@RequestBody Product product){
		Product updateEmployee = productService.updateProduct(product);
		return new ResponseEntity<Product>(updateEmployee,HttpStatus.OK);
	}
 	 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){ 
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/demo")
		public ResponseEntity<Product> offers(){
		System.out.println("Fetching Data");
			Offers[] offer =template.getForObject("http://localhost:8202/demo", Offers[].class) ;
			
			Product product = productService.findProductById(1);
			product.setOffers(offer);
			
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
	}
	 
	


