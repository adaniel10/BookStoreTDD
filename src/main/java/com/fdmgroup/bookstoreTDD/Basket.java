package com.fdmgroup.bookstoreTDD;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	
	private List<Book> books;
	
	public Basket() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooksInBasket() {
		return books;
	}

	public void addBook(Book book) {
		books.add(book);
	}

}
