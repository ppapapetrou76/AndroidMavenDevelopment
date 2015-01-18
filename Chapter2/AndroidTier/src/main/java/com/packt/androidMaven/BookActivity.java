package com.packt.androidMaven;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.packt.androidmaven.model.Book;
import com.packt.androidmaven.service.BookService;
import com.packt.androidmaven.service.BookServiceImpl;

public class BookActivity extends Activity {

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextValue();

    }

    private void setTextValue() {
        BookService bookService = new BookServiceImpl();
        final Book book = bookService.createBook("Maven and Android", "eBook", "black", 150);
        textView = (TextView) findViewById(R.id.text1);
        textView.setText(book.toString());
    }

}
