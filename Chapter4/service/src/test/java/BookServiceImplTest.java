package com.packt.androidmaven.service;

import com.packt.androidmaven.model.Book;
import org.junit.Assert;
import org.junit.Test;
public class BookServiceImplTest {
    
    private final BookService bookService = new BookServiceImpl();
    private static final String TITLE = "Maven and Android";
    private static final String FORMAT = "eBook";
    private static final String COLOR = "Black";
    private static final Integer PAGES = 190;
    
    @Test
    public void should_create_book() {
        
        Book actualBook = bookService.createBook(TITLE, FORMAT, COLOR, PAGES);
        Assert.assertEquals(TITLE, actualBook.getTitle());
        Assert.assertEquals(FORMAT, actualBook.getFormat());
        Assert.assertEquals(COLOR, actualBook.getColor());
        Assert.assertEquals(PAGES, actualBook.getNumberOfPages());
        Assert.assertNull(actualBook.getId());
        Assert.assertNull(actualBook.isBrandNew());
    }
}