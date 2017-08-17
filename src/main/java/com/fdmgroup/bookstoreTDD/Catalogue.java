package com.fdmgroup.bookstoreTDD;

import java.util.List;

public class Catalogue {
	private ReadItemCommand<Book> ric;
	private WriteItemCommand<Book> wic;

	public Catalogue(ReadItemCommand<Book> ric, WriteItemCommand<Book> wic) {
		this.ric = ric;
		this.wic = wic;
	}

	public List<Book> getAllBooks() {
		return ric.readAll();
	}

	public void addBook(Book book) {
		wic.insertItem(book);
	}

}
