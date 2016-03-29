package com.mydomain.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.Item;

import com.mydomain.shoppingcart.service.ShoppingService;

/** 
 * @author Ross
 */
public class ShoppingManager implements ShoppingService {

	public Collection<Item> findItems() {
		// ideally you would make a  call to the database to return list of items in the shop
		// so for now we will just return some dummy data
		List<Item> allItems = new ArrayList<Item>();
		Item item1 = new Item(1l, "Candy Cotton", "Candy coated milky tarts", 8.50d);
		Item item2 = new Item(2l, "Jelly Beans", "Jelly icecream waffle cream", 18.99d);
		Item item3 = new Item(3l, "Jam Doughnut", "Strawberry jam and Christmas pudding", 23.00d);
		Item item4 = new Item(4l, "Mallow Madness", "Marshmellow wrap", 8.50d);
		Item item5 = new Item(5l, "Chocolate Cheese", "Crunchy chocolate creamy cheese", 17.50d);
		Item item6 = new Item(6l, "Custard Crazy", "Custard sauce with jelly and cream", 13.55d);
		allItems.add(item1);
		allItems.add(item2);
		allItems.add(item3);
		allItems.add(item4);
		allItems.add(item5);
		allItems.add(item6);
		
		return allItems;
	}

	public void processPayment(Basket basket) {
	}

}