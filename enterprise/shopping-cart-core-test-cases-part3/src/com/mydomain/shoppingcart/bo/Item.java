package com.mydomain.shoppingcart.bo;

/** 
 * @author Ross
 */
public class Item {
	private String description;
	private Long id;
	private String name;
	private double price;

	public Item(Long id, String name, String description, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setDescription(String theDescription) {
		description = theDescription;
	}

	public void setId(Long theId) {
		id = theId;
	}

	public void setName(String theName) {
		name = theName;
	}
	
	public void setPrice(double thePrice) {
		price = thePrice;
	}
}