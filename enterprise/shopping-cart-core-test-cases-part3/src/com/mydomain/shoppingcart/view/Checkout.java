package com.mydomain.shoppingcart.view;


/** 
 * @author Ross
 */
public class Checkout {
	private ShoppingViewHelper shoppingViewHelper;
	
	private double total;

	public void cancelOrder() {
	}

	public ShoppingViewHelper getShoppingViewHelper() {
		return shoppingViewHelper;
	}

	public double getTotal() {
		return total;
	}

	public void processPayment() {
	}
	
	public void setShoppingviewhelper(ShoppingViewHelper shoppingViewHelper) {
		this.shoppingViewHelper = shoppingViewHelper;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}