package com.mastek.training.myshop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class setShoppingCart implements ShoppingCart<Item> {
	
	Set<Item> items;
	
	public setShoppingCart() {
		//using HashSet to manage unique items in random order
		//items = new HashSet<>();//diamond operator(<>) with new keyword, since jdk 1.7
				// New HashSet <Item>();
		
		//using Treeset to store otems in sorted order 
		items = new TreeSet<>();
	}

	@Override
	public int addItem(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in cart");
		for (Item item : items) {
			System.out.println(item);
		}
			
	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
