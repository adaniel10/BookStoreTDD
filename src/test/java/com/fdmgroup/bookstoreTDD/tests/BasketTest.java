package com.fdmgroup.bookstoreTDD.tests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.bookstoreTDD.Basket;
import com.fdmgroup.bookstoreTDD.Book;

public class BasketTest {
	
	Basket basket;
	List<Book> books;
	Book book;
	Book book2;
	
	@Before
	public void init() {
		basket = new Basket();
		books = new ArrayList<Book>();
		book = new Book("Harry Potter", 6.99);
	}
	
	@Test
	public void test_GestBooksInBasket_ReturnEmptyBookList_IfNoBooksHaveBeenAdded() {
		books = basket.getBooksInBasket();
		assertEquals(0,books.size());
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook(){
		basket.addBook(book);
		books = basket.getBooksInBasket();
		assertEquals(1,books.size());
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledWithTwoBooks(){
		basket.addBook(book);
		basket.addBook(book2);
		books = basket.getBooksInBasket();
		assertEquals(2,books.size());
	}
}
