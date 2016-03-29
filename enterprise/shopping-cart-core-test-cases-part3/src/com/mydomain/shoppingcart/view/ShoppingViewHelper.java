package com.mydomain.shoppingcart.view;

import java.util.List;

import com.mydomain.shoppingcart.bo.Item;
import com.mydomain.shoppingcart.service.ShoppingService;
import com.mydomain.shoppingcart.service.impl.ShoppingManager;

/** 
 * @author Ross
 */
public class ShoppingViewHelper {
	private ShoppingManager shoppingManager;

	public void addItemToBasket(Item item) {
	}
	
	public List<Item> findItems() {
		return null;
	}

	public ShoppingService getShoppingManager() {
		return shoppingManager;
	}

	public void processPayment() {
	}
	
	public void removeItemFromBasket(Item item) {
	}

	public void setShoppingManager(ShoppingManager shoppingManager) {
		this.shoppingManager = shoppingManager;
	}
}