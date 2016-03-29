package com.mydomain.shoppingcart.view;

import java.util.List;

import com.mydomain.shoppingcart.bo.Basket;
import com.mydomain.shoppingcart.bo.Item;

/** 
 * @author Ross
 */
public class Items {
	private Basket basket;
	private Item item;
	private ShoppingViewHelper shoppingViewHelper;

	public void addItemToBasket() {
	}

	public void checkout() {
	}

	public List<Item> findItems() {
		return null;
	}

	public Basket getBasket() {
		return basket;
	}

	public Item getItem() {
		return item;
	}

	public ShoppingViewHelper getShoppingViewHelper() {
		return shoppingViewHelper;
	}

	public void removeItemFromBasket() {
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setShoppingviewhelper(ShoppingViewHelper shoppingViewHelper) {
		this.shoppingViewHelper = shoppingViewHelper;
	}
}