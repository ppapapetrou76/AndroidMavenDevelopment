package com.packt.androidmaven.service;

import com.packt.androidmaven.model.Book;

public class BookServiceImpl implements BookService {
    
    @Override
    public Book createBook(String title, String format, String color, Integer numberOfPages) {
        final Book book = new Book();
        book.setTitle(title);
        book.setFormat(format);
        book.setColor(color);
        book.setNumberOfPages(numberOfPages);
        return book;
    }
}