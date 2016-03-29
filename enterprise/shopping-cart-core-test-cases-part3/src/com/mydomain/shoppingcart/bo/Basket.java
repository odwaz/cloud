package com.mydomain.shoppingcart.bo;

import java.util.ArrayList;
import java.util.List;


/** 
 * @author Ross
 */
public class Basket {
	private Long id;
	private List<Item> items;
	private String userid;

	public void addItem(Item item) {
		getItems().add(item);
	}

	public void empty() {
		setItems(new ArrayList<Item>());
	}

	public double getBalance() {
		double balance = 0;
		for (Item item : getItems()) {
			balance = balance + item.getPrice();
		}
		return balance;
	}
	
	public Long getId() {
		return id;
	}
	
	public int getItemCount() {
		return getItems().size();
	}

	public List<Item> getItems() {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		return items;
	}

	public String getUserid() {
		return userid;
	}
	
	public void removeItem(Item item) {
		getItems().remove(item);
	}
	
	public void setId(Long theId) {
		id = theId;
	}
	
	public void setItems(List<Item> theItems) {
		items = theItems;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
}