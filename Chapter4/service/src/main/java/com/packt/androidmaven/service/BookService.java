
package com.packt.androidmaven.service;

import com.packt.androidmaven.model.Book;

public interface BookService {
    Book createBook(String title, String format, String color, Integer numberOfPages);
}
