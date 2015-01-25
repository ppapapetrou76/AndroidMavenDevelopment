package com.packt.androidMaven;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_SHORT;
import com.packt.androidmaven.model.Book;
import com.packt.androidmaven.service.BookService;
import com.packt.androidmaven.service.BookServiceImpl;

public class BookActivity extends Activity {

    private Button button;
    private TextView textView;
    public final static String AUTHOR = "com.packt.androidMaven.AUTHOR";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextValue();

        addListenerOnButton();
        addListenerOnPaidButton();
    }

    private void setTextValue() {
        BookService bookService = new BookServiceImpl();
        final Book book = bookService.createBook("Maven and Android", "eBook", "black", 150);
        textView = (TextView) findViewById(R.id.text1);
        textView.setText(book.toString());
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AuthorActivity.class);
                intent.putExtra(AUTHOR, "Patroklos Papapetrou");
                startActivity(intent);
            }
        });
    }
    
    public void addListenerOnPaidButton() {
        button = (Button) findViewById(R.id.paidbutton);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.packt.paid.intent.action.Launch");
                try {
                    startActivity(intent);                
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(view.getContext(), "You need to purchase the full version!", LENGTH_SHORT).show();
                }
            }
        });
    }  
}