package com.packt.androidMaven.tests;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import com.packt.androidMaven.BookActivity;
import android.R;

public class BookActivityTest extends ActivityUnitTestCase<BookActivity>{

    BookActivity bookActivity;

    // TextView of the MainActivity to be tested
    private TextView textView;
    private Button button;

    public BookActivityTest() {
        super(BookActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Starts the MainActivity of the target application
        startActivity(new Intent(getInstrumentation().getTargetContext(), BookActivity.class), null, null);

        // Getting a reference to the MainActivity of the target application
        bookActivity = (BookActivity)getActivity();

        // Getting a reference to the TextView of the MainActivity of the target application
        textView = (TextView) bookActivity.findViewById(R.id.text1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testHello(){
        // The actual text displayed in the textview
        String actual=textView.getText().toString();

        // The expected text to be displayed in the textview
        String expected = "Hello world!";

        // Check whether both are equal, otherwise test fails
        assertEquals(expected,actual );
    }
}