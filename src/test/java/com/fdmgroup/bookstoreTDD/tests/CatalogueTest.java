package com.fdmgroup.bookstoreTDD.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import com.fdmgroup.bookstoreTDD.Book;
import com.fdmgroup.bookstoreTDD.Catalogue;
import com.fdmgroup.bookstoreTDD.ReadItemCommand;
import com.fdmgroup.bookstoreTDD.WriteItemCommand;

public class CatalogueTest {

   List<Book> bookList;

    @Mock
    Book mockBook;

    @Mock
    List<Book> mockBookList;

    @Mock
    ReadItemCommand<Book> ric;

    @Mock
    WriteItemCommand<Book> wic;

    @InjectMocks
    Catalogue testCatalogue;

    @Before
    public void init(){
        bookList = new ArrayList<Book>();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_GetAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue(){
        //when(ric.readAll()).thenReturn(mockBookList);
    	bookList = testCatalogue.getAllBooks();
        assertEquals(0,bookList.size());
    }

    @Test
    public void test_GetAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled(){
        testCatalogue.getAllBooks();
        //verifies the ric calls the readAll method in getAllBooks
        verify(ric,times(1)).readAll();
    }

    @Test
    public void test_GetAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){
    	when(ric.readAll()).thenReturn(mockBookList);
    	bookList = testCatalogue.getAllBooks();
        assertEquals(bookList,mockBookList);
    }

    @Test
    public void test_AddBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled(){
    	testCatalogue.addBook(mockBook);
    	verify(wic).insertItem(mockBook);
    }

    @Test
    public void test_AddBook_PassesBookToInsertItemMethodOfWriteItemCommand_WhenCalled(){
        testCatalogue.addBook(mockBook);
        verify(wic,times(1)).insertItem(mockBook);
    }

}
