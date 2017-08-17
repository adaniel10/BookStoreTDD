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
import com.fdmgroup.bookstoreTDD.Checkout;

public class CheckoutTest {
	
	Checkout checkout;
	Basket basket;
	Book book, book2, book3, book4, book5, book6, book7, book8, book9, book10;
	
	@Before
	public void init() {
		checkout = new Checkout();
		basket = new Basket();
		book = new Book("Harry Potter", 25.99);
		book2 = new Book("Willy Wonka", 25.99);
		book3 = new Book("Candy Cane", 25.99);
		book4 = new Book("Sizzle Snake", 25.99);
		book5 = new Book("Magic Mike", 25.99);
		book6 = new Book("Oreo Shake", 25.99);
		book7 = new Book("Pizza Book", 25.99);
		book8 = new Book("Toppings Book", 25.99);
		book9 = new Book("Sports Book", 25.99);
		book10 = new Book("Cook Book", 25.99);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket(){
		assertEquals(0.0,checkout.calculatePrice(basket),0.0);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook(){
		basket.addBook(book);
		assertEquals(25.99,checkout.calculatePrice(basket),0.001);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithTwoBook(){
		basket.addBook(book);
		basket.addBook(book2);
		assertEquals(51.98,checkout.calculatePrice(basket),0.001);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithThreeBooks(){
		basket.addBook(book);
		basket.addBook(book2);
		basket.addBook(book3);
		assertEquals(77.19,checkout.calculatePrice(basket),0.001);		
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithSevenBooks(){
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		assertEquals(178.29,checkout.calculatePrice(basket),0.005);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithTenBooks(){
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		assertEquals(226.11,checkout.calculatePrice(basket),0.005);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithUniqueBooks(){
		basket.addBook(book);
		basket.addBook(book2);
		basket.addBook(book3);
		basket.addBook(book4);
		basket.addBook(book5);
		basket.addBook(book6);
		basket.addBook(book7);
		basket.addBook(book8);
		basket.addBook(book9);
		basket.addBook(book10);
		assertEquals(213.12,checkout.calculatePrice(basket),0.005);
	}
}
