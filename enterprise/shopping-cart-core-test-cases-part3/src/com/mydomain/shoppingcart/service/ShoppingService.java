package com.mydomain.shoppingcart.service;

import java.util.Collection;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.Item;

/** 
 * @author Ross
 */
public interface ShoppingService {
	public Collection<Item> findItems();
	public void processPayment(Basket basket);
}