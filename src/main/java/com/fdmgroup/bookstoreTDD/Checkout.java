package com.fdmgroup.bookstoreTDD;

import java.util.List;

public class Checkout {

	public double calculatePrice(Basket basket) {
		List<Book> bookList = basket.getBooksInBasket();
		double totalPrice = 0.0;
		
		for(Book book : bookList) {
			totalPrice += book.getPrice();
		}
		
		return totalPrice - calculateDiscountPrice(bookList, totalPrice);
	}

	private double calculateDiscountPrice(List<Book> bookList, double totalPrice) {
		
		boolean isUnique = false;
		for(int i=0; i<bookList.size(); i++) {
			for(int j=i+1; j<bookList.size(); j++) {
				if(!bookList.get(j).equals(bookList.get(i)))
					isUnique = true;
				else
					isUnique = false;
			}
		}
	
		if(isUnique)
			return 0.18 * totalPrice;
		else if(bookList.size() >= 10)
			return 0.13 * totalPrice;
		else if(bookList.size() >= 7)
			return 0.02 * totalPrice;
		else if(bookList.size() >= 3)
			return 0.01 * totalPrice;
		else
			return 0.0;
	}
}
