
package com.packt.androidmaven.chapter2.service;

import com.packt.androidmaven.chapter2.model.Book;

public interface BookService {
    Book createBook(String title, String format, String color, Integer numberOfPages);
}
