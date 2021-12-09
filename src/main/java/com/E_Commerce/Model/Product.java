package com.E_Commerce.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false,updatable =false)
	private int id;
	private String Name;
	private String Size;
	private String Description;
	private Integer Quantity;
	
	private String photoaddress;
	@ManyToOne
	private Category category;
	
	private Offers[] offers;
	

	


	public Product() {}
	
	
	
	
	public Product(String name, String size, String description, Integer quantity, String photoaddress,
			Category category,Offers[] offers) {
		super();
		Name = name;
		Size = size;
		Description = description;
		Quantity = quantity;
		this.photoaddress = photoaddress;
		this.category = category;
		this.offers=offers;
	}




	public Product(int id, String name, String size, String description, int quantity, String category,String photoaddress,Offers[] offers) {
		super();
		this.id = id;
		Name = name;
		Size = size;
		Description = description;
		this.Quantity = quantity;
		
		this.photoaddress=photoaddress;
		this.offers=offers;
	}
	public Offers[] getOffers() {
		return offers;
	}




	public void setOffers(Offers[] offer) {
		this.offers = offer;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}
	
	

	public String getPhotoAddress() {
		return photoaddress;
	}


	public void setPhotoAddress(String photoaddress) {
		this.photoaddress = photoaddress;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	

}
